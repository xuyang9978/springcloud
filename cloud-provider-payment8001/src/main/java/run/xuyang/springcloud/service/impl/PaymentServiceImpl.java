package run.xuyang.springcloud.service.impl;

import org.springframework.stereotype.Service;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.mapper.PaymentMapper;
import run.xuyang.springcloud.service.PaymentService;

/**
 * @author XuYang
 * @date 2020/8/31 21:14
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
