package run.xuyang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author XuYang
 * @date 2020/9/2 15:54
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class ConsulOrderController {

    /**
     * 服务调用地址
     */
    public static final String INVOKE_URL = "http://cloud-provider-consul-payment";

    private final RestTemplate restTemplate;

    public ConsulOrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/payment/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
