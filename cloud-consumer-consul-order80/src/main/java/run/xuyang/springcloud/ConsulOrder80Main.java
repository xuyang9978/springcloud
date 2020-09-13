package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XuYang
 * @date 2020/9/2 15:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrder80Main {

    public static void main(String[] args) {
        SpringApplication.run(ConsulOrder80Main.class, args);
    }
}
