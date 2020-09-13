package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XuYang
 * @date 2020/9/2 13:24
 */
// 该注解用于向 consul 或者 zookeeper 作为注册中心时注册服务
@EnableDiscoveryClient
@SpringBootApplication
public class ZKPayment8004Main {

    public static void main(String[] args) {
        SpringApplication.run(ZKPayment8004Main.class, args);
    }
}
