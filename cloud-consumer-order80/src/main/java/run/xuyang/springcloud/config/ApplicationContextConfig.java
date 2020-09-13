package run.xuyang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate 配置类
 *
 * @author XuYang
 * @date 2020/9/1 14:11
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced   // 赋予 RestTemplate 负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
