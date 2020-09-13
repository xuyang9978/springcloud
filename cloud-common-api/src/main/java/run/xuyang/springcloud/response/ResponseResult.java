package run.xuyang.springcloud.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装后返回给前端的结果
 *
 * @author XuYang
 * @date 2020/8/31 20:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseResult(Integer code, String message) {
        this(code, message, null);
    }
}
