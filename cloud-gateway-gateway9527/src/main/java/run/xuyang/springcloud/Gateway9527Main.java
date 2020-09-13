package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XuYang
 * @date 2020/9/6 16:03
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527Main {

    public static void main(String[] args) {
        SpringApplication.run(Gateway9527Main.class, args);
    }
}
