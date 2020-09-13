package run.xuyang.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 自定义 gateway 过滤器
 *
 * @author XuYang
 * @date 2020/9/6 18:29
 */
@Component
@Slf4j
public class CustomGatewayLogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********come in CustomGatewayLogFilter: " + new Date());
        // 判断请求的第一个参数是不是 username
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null || username.length() == 0) {
            log.info("用户名为 null, 非法用户!");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 数字越小, 过滤器的优先级越高
        return 0;
    }
}
