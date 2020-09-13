package run.xuyang.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.response.ResponseResult;


@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    ResponseResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
