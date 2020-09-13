package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author XuYang
 * @date 2020/9/5 16:35
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignHystrixOrder80Main {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrder80Main.class, args);
    }
}
