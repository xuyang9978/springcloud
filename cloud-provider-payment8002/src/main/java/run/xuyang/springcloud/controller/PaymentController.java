package run.xuyang.springcloud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.response.ResponseResult;
import run.xuyang.springcloud.service.PaymentService;

import java.util.List;

/**
 * @author XuYang
 * @date 2020/8/31 21:53
 */
@Tag(name = "PaymentController", description = "支付接口")
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private final PaymentService paymentService;

    /**
     * 服务发现
     */
    private final DiscoveryClient discoveryClient;

    public PaymentController(PaymentService paymentService, DiscoveryClient discoveryClient) {
        this.paymentService = paymentService;
        this.discoveryClient = discoveryClient;
    }

    @Operation(summary = "创建一个支付记录", description = "只需传入 serial 参数即可, id 自增的")
    @PostMapping("/create")
    public ResponseResult<Long> create(
            @Parameter(description = "支付实体类对象")
            @RequestBody Payment payment) {
        paymentService.create(payment);
        // 注意这里如何获取插入后生成的主键的, 不要使用
        // int result = paymentService.create(payment);
        // 这种返回的是影响的行数
        long result = payment.getId();
        log.info("========插入结果: " + result);
        if (result > 0) {
            return new ResponseResult<>(200, "插入数据成功, serverPort: " + serverPort, result);
        }
        return new ResponseResult<>(444, "插入数据失败, serverPort: " + serverPort);
    }

    @Operation(summary = "根据 id 查询一个支付记录", description = "根据 id 查询一个支付记录")
    @GetMapping("/get/{id}")
    public ResponseResult<Payment> getPaymentById(
            @Parameter(description = "支付 id")
            @PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("========查询结果: " + payment);
        if (payment != null) {
            return new ResponseResult<>(200, "查询成功, serverPort: " + serverPort, payment);
        }
        return new ResponseResult<>(444, "查询id:" + id + ",没有对应记录, serverPort: " + serverPort);
    }

    /**
     * 查看本服务的一些信息
     */
    @GetMapping("/discovery")
    public Object discovery() {
        // 获取 Eureka 上注册了的所有的微服务名称
        // 输出结果:
        // ========service: cloud-payment-service
        // ========service: cloud-order-service
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("========service: " + service);
        }

        // 根据服务名称获取该服务的实例(即看这一个服务有多少个提供者以及这些提供者的详细信息)
        // 输出结果:
        // CLOUD-PAYMENT-SERVICE	192.168.181.1	8002	http://192.168.181.1:8002
        // CLOUD-PAYMENT-SERVICE	192.168.181.1	8001	http://192.168.181.1:8001
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t"
                    + instance.getHost() + "\t"
                    + instance.getPort() + "\t"
                    + instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 返回当前端口号
     */
    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
