package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XuYang
 * @date 2020/9/7 9:00
 */
@SpringBootApplication
//@EnableEurekaClient   // 这个不用配置也可以注册服务
public class ConfigClient3355Main {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355Main.class, args);
    }
}
