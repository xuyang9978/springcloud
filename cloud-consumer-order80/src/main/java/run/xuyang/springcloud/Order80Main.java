package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import run.xuyang.rule.MyselfRule;

/**
 * @author XuYang
 * @date 2020/9/1 13:51
 */
@EnableEurekaClient
@SpringBootApplication
// 引入自定义的负载均衡算法
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyselfRule.class)
public class Order80Main {

    public static void main(String[] args) {
        SpringApplication.run(Order80Main.class, args);
    }
}
