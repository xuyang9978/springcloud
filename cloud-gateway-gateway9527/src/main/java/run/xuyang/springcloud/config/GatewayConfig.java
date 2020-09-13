package run.xuyang.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关配置(可以选择写这个配置文件然后就不需要在 yml 中配置, 配置了 yml 就不需要这个配置类)
 *
 * @author XuYang
 * @date 2020/9/6 16:21
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置了一个 id 为 path_route_xuyang 的路由规则,
     * 当访问 http://localhost:9527/guonei 时会自动转发到地址 http://news.baidu.com/guonei
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes
                .route("path_route_xuyang", r -> r
                        .path("/guonei")
                        .uri("http://news.baidu.com/guonei"));

        return routes.build();
    }
}
