package run.xuyang.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import run.xuyang.springcloud.alibaba.handler.CustomerBlockHandler;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.response.ResponseResult;


@RestController
public class RateLimitController {

    //=========================按资源名进行限流
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public ResponseResult<Payment> byResource() {
        return new ResponseResult<>(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public ResponseResult handleException(BlockException exception) {
        return new ResponseResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    //========================按 URL 进行限流
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public ResponseResult<Payment> byUrl() {
        return new ResponseResult<>(200, "按 url 限流测试 OK", new Payment(2020L, "serial002"));
    }

    //========================使用自定义的限流处理类
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",   // 资源名
            blockHandlerClass = CustomerBlockHandler.class, // 要使用哪一个类来处理
            blockHandler = "handlerException2") // 使用指定类中的哪个方法进行处理
    public ResponseResult customerBlockHandler() {
        return new ResponseResult(200, "按客户自定义限流测试 OK", new Payment(2020L, "serial003"));
    }

}
