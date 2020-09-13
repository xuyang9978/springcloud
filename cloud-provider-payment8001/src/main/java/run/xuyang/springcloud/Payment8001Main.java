package run.xuyang.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 *
 * @author XuYang
 * @date 2020/8/31 20:02
 */
@EnableEurekaClient
@MapperScan("run.xuyang.springcloud.mapper")
@SpringBootApplication
public class Payment8001Main {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001Main.class, args);
    }
}
