package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author XuYang
 * @date 2020/9/1 17:41
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002Main {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002Main.class, args);
    }
}
