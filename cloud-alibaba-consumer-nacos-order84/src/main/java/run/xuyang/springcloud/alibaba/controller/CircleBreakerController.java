package run.xuyang.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import run.xuyang.springcloud.alibaba.service.PaymentService;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.response.ResponseResult;


@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    private final RestTemplate restTemplate;

    private final PaymentService paymentService;


    public CircleBreakerController(RestTemplate restTemplate, PaymentService paymentService) {
        this.restTemplate = restTemplate;
        this.paymentService = paymentService;
    }

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") // 没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback") // fallback 属性只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")    // 只有满足限流条件时才会触发 blockHandler
    // 如果两个都配置了，那么满足流控规则时由 blockHandler 属性进行处理，不满足流控规则发生异常时交给 fallback 属性处理
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "handlerFallback",
            blockHandler = "blockHandler", exceptionsToIgnore = IllegalArgumentException.class)  // exceptionsToIgnore 忽略指定类型的异常
    public ResponseResult<Payment> fallback(@PathVariable Long id) {
        ResponseResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, ResponseResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该 ID 没有对应记录,空指针异常");
        }

        return result;
    }

    // 本例是 fallback 兜底方法，处理业务异常
    public ResponseResult<Payment> handlerFallback(Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new ResponseResult<>(444, "兜底异常 handlerFallback,exception 内容  " + e.getMessage(), payment);
    }

    //本例是 blockHandler 满足限流规则时候调用的方法，处理限流
    public ResponseResult<Payment> blockHandler(Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new ResponseResult<>(445, "blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(), payment);
    }

    //==================OpenFeign
    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public ResponseResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
