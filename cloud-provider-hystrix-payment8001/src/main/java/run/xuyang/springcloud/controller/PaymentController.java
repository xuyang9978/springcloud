package run.xuyang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.xuyang.springcloud.service.PaymentService;


/**
 * @author XuYang
 * @date 2020/9/5 15:29
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Value("${server.port}")
    private String serverPort;

    /**
     * 正常的方法
     */
    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOK(id);
        log.info("******result: " + result);
        return result;
    }

    /**
     * 可能会导致异常的方法
     */
    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("******result: " + result);
        return result;
    }

    // ============= 服务熔断 =================
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("********result: " + result);
        return result;
    }

}
