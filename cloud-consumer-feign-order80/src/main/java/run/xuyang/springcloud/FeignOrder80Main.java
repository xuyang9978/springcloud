package run.xuyang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author XuYang
 * @date 2020/9/5 9:44
 */
@SpringBootApplication
// 开启 feign 的使用
@EnableFeignClients
public class FeignOrder80Main {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrder80Main.class, args);
    }
}
