package run.xuyang.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import run.xuyang.springcloud.service.IMessageProvider;

/**
 * @author XuYang
 * @date 2020/9/7 14:39
 */
@RestController
public class SenMessageController {

    private final IMessageProvider iMessageProvider;

    public SenMessageController(IMessageProvider iMessageProvider) {
        this.iMessageProvider = iMessageProvider;
    }

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
