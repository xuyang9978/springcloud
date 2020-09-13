package run.xuyang.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XuYang
 * @date 2020/9/10 9:08
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelService8401Main {

    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401Main.class, args);
    }
}
