package run.xuyang.springcloud.service;

import run.xuyang.springcloud.entity.Payment;

/**
 * @author XuYang
 * @date 2020/8/31 21:13
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
