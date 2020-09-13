package run.xuyang.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author XuYang
 * @date 2020/9/5 21:59
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "=========PaymentFallbackService fall back paymentInfoOK";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "=========PaymentFallbackService fall back paymentInfoTimeout";
    }
}
