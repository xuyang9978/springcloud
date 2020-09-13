package run.xuyang.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XuYang
 * @date 2020/9/8 20:29
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigNacosClient3377Main {

    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosClient3377Main.class, args);
    }
}
