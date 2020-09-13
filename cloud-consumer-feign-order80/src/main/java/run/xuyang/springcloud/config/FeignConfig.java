package run.xuyang.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Feign 相关配置
 *
 * @author XuYang
 * @date 2020/9/5 14:19
 */
@Configuration
public class FeignConfig {

    /**
     * 配置日志
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        // FULL 打印请求信息以及请求的数据信息
        return Logger.Level.FULL;
    }

}
