package run.xuyang.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * 为了方便没有写接口和实现类, 直接写实现类
 *
 * @author XuYang
 * @date 2020/9/5 14:57
 */
@Service
public class PaymentService {

    /**
     * 正常的方法
     */
    public String paymentInfoOK(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfoOK, id:  " + id + "\t哈哈哈";
    }

    /**
     * 可能会致异常的方法
     */
    // 指定出现了异常的话找谁解决
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",
            // 规定三秒钟为超时时间, 超时会手动抛出异常
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String paymentInfoTimeout(Integer id) {
        int time = 0;
//        int age = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfoTimeout, id:  " +
                id + "\t呜呜呜, 耗时" +
                time + "秒钟";
    }

    /**
     * 当 paymentInfoTimeout 方法出现异常时调用这个方法
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return "8001 系统繁忙,请稍后重试.嘻嘻嘻";
    }

    // ==================== 服务熔断 ======================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }

}
