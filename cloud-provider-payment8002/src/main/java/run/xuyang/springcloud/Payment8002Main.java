package run.xuyang.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XuYang
 * @date 2020/9/1 19:02
 */
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("run.xuyang.springcloud.mapper")
@SpringBootApplication
public class Payment8002Main {

    public static void main(String[] args) {
        SpringApplication.run(Payment8002Main.class, args);
    }
}
