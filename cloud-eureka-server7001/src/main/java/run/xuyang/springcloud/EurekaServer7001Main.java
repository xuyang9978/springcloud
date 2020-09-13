package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author XuYang
 * @date 2020/9/1 16:25
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001Main {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001Main.class, args);
    }
}
