package run.xuyang.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义使用的负载均衡算法(Ribbon 有七种默认的算法)
 *
 * 注意该类所在的位置不能放在 @ComponentScan 所扫描的当前包(也就是启动类所在的包)
 * 以及子包下,否则自定义的这个配置类就会被所有的 Ribbon 客户端所共享,
 * 就达不到特殊化定制的目的了
 *
 * @author XuYang
 * @date 2020/9/2 21:05
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule() {
        // 使用随机算法
        return new RandomRule();
    }
}
