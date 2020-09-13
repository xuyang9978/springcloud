package run.xuyang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.xuyang.springcloud.service.PaymentHystrixService;

/**
 * @author XuYang
 * @date 2020/9/5 16:39
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
// 默认服务降级处理方法
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    private final PaymentHystrixService paymentHystrixService;

    public OrderHystrixController(PaymentHystrixService paymentHystrixService) {
        this.paymentHystrixService = paymentHystrixService;
    }


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoOK(id);
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    @HystrixCommand // 这里不指明处理方法, 会调用默认的
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    /**
     * 报错的处理方法
     */
    public String paymentTimeoutFallbackMethod(Integer id) {
        return "我是消费者 80, 对方支付系统繁忙, 请 10 秒钟后再试或自己运行出错检查自己, 嘻嘻嘻嘻";
    }

    /**
     * 全局 fallback 方法, 如果没有指定 fallback 方法那么就会使用这个默认的
     */
    public String paymentGlobalFallbackMethod() {
        return "Global 异常处理信息, 请稍后再试, 哭泣!";
    }
}
