package run.xuyang.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import run.xuyang.springcloud.entity.Payment;
import run.xuyang.springcloud.response.ResponseResult;

/**
 * 自定义的限流处理逻辑
 *
 * @author XuYang
 * @date 2020/9/10 20:12
 */
public class CustomerBlockHandler {

    public static ResponseResult handlerException(BlockException exception) {
        return new ResponseResult(4444, "按客户自定义, Global handlerException--------1");
    }

    public static ResponseResult handlerException2(BlockException exception) {
        return new ResponseResult(4444, "按客户自定义, Global handlerException--------2");
    }
}
