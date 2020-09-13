package run.xuyang.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class FlowLimitController {

    //=======================测试流控规则
    @GetMapping("/testA")
    public String testA() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info(Thread.currentThread().getName() + "\t...testB");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    //=========================测试熔断降级
    @GetMapping("/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试 RT");
        log.info("testD 异常比例");
        int age = 10 / 0;
        return "-------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10 / 0;
        return "testE 测试异常数";
    }

    //===========================测试热点规则
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")    // 这里的 value 是唯一标识, 可以和路径名不相同
    @GetMapping("/testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        // 注意: @SentinelResource 注解只管 Sentinel 配置了的限流规则, 如果没有满足限流的规则, 不会触发兜底的方法,
        // 即使你触发了异常也不会调用兜底的方法, 除非你满足了限流条件
        int age = 10 / 0;
        return "------testHotKey";
    }

    /**
     * 当热点 Key 限流满足条件时调用的方法
     */
    public String dealTestHotKey(String p1, String p2, BlockException exception) {
        return "----------dealTestHotKey";  // Sentinel 系统默认的提示: Blocked by Sentinel(flow limiting)
    }
}
