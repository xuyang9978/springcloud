package run.xuyang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.response.ResponseResult;

/**
 * @author XuYang
 * @date 2020/9/5 9:46
 */
@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")   // 指定要调用的服务名字
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    ResponseResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 测试 feign 的控制超时功能
     */
    @GetMapping("/payment/feign/timeout")
    String PaymentFeignTimeout();
}
