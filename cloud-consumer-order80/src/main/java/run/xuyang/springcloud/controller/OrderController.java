package run.xuyang.springcloud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.lb.MySelfLoadBalancer;
import run.xuyang.springcloud.response.ResponseResult;

import java.net.URI;
import java.util.List;


/**
 * @author XuYang
 * @date 2020/9/1 13:57
 */
@SuppressWarnings("unchecked")
@Tag(name = "OrderController", description = "订单相关接口")
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    // 使用单机直接写死
//    public static final String PAYMENT_URL = "http://localhost:8001";
    // 微服务就不要写死了, 而是根据服务名去注册中心找
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    /**
     * 自定义的负载均衡算法接口
     */
    private final MySelfLoadBalancer mySelfLoadBalancer;

    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;

    public OrderController(MySelfLoadBalancer mySelfLoadBalancer, DiscoveryClient discoveryClient, RestTemplate restTemplate) {
        this.mySelfLoadBalancer = mySelfLoadBalancer;
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    @Operation(summary = "创建一个支付记录", description = "只需传入 serial 参数即可, id 自增的")
    @PostMapping("/payment/create")
    public ResponseResult<Payment> create(
            @Parameter(description = "支付实体类对象")
            @RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, ResponseResult.class);
    }

    @Operation(summary = "根据 id 查询一个支付记录", description = "根据 id 查询一个支付记录")
    @GetMapping("/payment/get/{id}")
    public ResponseResult<Payment> getPaymentById(
            @Parameter(description = "支付 id")
            @PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ResponseResult.class);
    }

    // 测试 get/postForEntity 和 get/postForObject 的区别
    // 前者返回对象为 ResponseEntity 对象，有更多详细的信息(比如响应头, 状态码等)
    // 后者返回对象为响应体中数据转化成的对象, 基本可以理解为 json
    @Operation(summary = "根据 id 查询一个支付记录", description = "根据 id 查询一个支付记录")
    @GetMapping("/payment/getForEntity/{id}")
    public ResponseResult<Payment> getPayment(
            @Parameter(description = "支付 id")
            @PathVariable("id") Long id) {
        ResponseEntity<ResponseResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, ResponseResult.class);
        log.info(entity.getStatusCode().toString());
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return new ResponseResult<>(444, "操作失败！");
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = mySelfLoadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    /**
     * zipkin + sleuth
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
    }

}
