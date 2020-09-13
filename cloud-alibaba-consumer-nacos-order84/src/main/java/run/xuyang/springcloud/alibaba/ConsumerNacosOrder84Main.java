package run.xuyang.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author XuYang
 * @date 2020/9/10 20:57
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsumerNacosOrder84Main {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosOrder84Main.class, args);
    }
}
