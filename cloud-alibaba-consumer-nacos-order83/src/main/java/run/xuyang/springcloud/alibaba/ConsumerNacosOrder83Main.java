package run.xuyang.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XuYang
 * @date 2020/9/8 20:04
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerNacosOrder83Main {
    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerNacosOrder83Main.class,args);
    }
}
