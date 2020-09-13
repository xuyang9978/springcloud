package run.xuyang.springcloud.alibaba.service;

import org.springframework.stereotype.Component;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.response.ResponseResult;

/**
 * 出现服务降级时兜底的类
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public ResponseResult<Payment> paymentSQL(Long id) {
        return new ResponseResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
