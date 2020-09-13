package run.xuyang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.response.ResponseResult;
import run.xuyang.springcloud.service.PaymentFeignService;

/**
 * @author XuYang
 * @date 2020/9/5 9:52
 */
@RestController
@Slf4j
public class OrderFeignController {

    private final PaymentFeignService paymentFeignService;

    public OrderFeignController(PaymentFeignService paymentFeignService) {
        this.paymentFeignService = paymentFeignService;
    }

    @GetMapping("/consumer/payment/get/{id}")
    ResponseResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * 测试 feign 的控制超时功能
     */
    @GetMapping("/consumer/payment/feign/timeout")
    public String PaymentFeignTimeout() {
        // open-feign-ribbon 客户端一般默认等待 1 秒钟
        return paymentFeignService.PaymentFeignTimeout();
    }
}
