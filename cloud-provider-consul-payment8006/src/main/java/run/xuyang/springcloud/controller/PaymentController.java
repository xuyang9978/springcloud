package run.xuyang.springcloud.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author XuYang
 * @date 2020/9/2 13:26
 */
@Tag(name = "PaymentController", description = "支付接口")
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String paymentConsul() {
        return "springcloud with consul: " +
                serverPort + "\t" +
                UUID.randomUUID().toString();
    }
}
