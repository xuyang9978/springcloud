package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author XuYang
 * @date 2020/9/6 9:42
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启图形化监控
public class HystrixDashboard9001Main {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001Main.class, args);
    }
}
