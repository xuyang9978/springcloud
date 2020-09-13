package run.xuyang.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XuYang
 * @date 2020/9/8 18:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderPayment9002Main {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPayment9002Main.class, args);
    }
}
