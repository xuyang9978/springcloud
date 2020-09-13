package run.xuyang.springcloud.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author XuYang
 * @date 2020/9/2 13:26
 */
@Tag(name = "ZKOrderController", description = "订单接口")
@RestController
@Slf4j
@RequestMapping("/consumer")
public class ZKOrderController {

    /**
     * 服务调用地址
     */
    public static final String INVOKE_URL = "http://cloud-provider-zk-payment";

    private final RestTemplate restTemplate;

    public ZKOrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/payment/zk")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
