package run.xuyang.springcloud.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import run.xuyang.springcloud.entity.Payment;

/**
 * @author XuYang
 * @date 2020/8/31 20:30
 */
@Repository
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
