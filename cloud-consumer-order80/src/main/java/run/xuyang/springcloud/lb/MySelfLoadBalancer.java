package run.xuyang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义轮询负载均衡
 *
 * @author XuYang
 * @date 2020/9/2 22:10
 */
public interface MySelfLoadBalancer {

    /**
     * 从所有的服务实例中轮询选出接收请求的服务实例
     *
     * @param serviceInstances 所有的服务实例集合
     * @return 接收此次请求的服务实例
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
