package run.xuyang.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XuYang
 * @date 2020/9/10 20:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9004Main {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9004Main.class, args);
    }
}
