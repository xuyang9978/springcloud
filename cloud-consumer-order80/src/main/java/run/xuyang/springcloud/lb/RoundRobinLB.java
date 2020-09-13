package run.xuyang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author XuYang
 * @date 2020/9/2 22:13
 */
@Component
public class RoundRobinLB implements MySelfLoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 得到当前值并返回下一次的值
     *
     * @return 下一次的值
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            // 自旋锁, 不断自旋直到获取到期望值
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("======访问次数: " + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
