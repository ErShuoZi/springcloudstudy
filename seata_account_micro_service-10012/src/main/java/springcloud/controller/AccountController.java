package springcloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entity.Result;
import springcloud.service.AccountService;

import javax.annotation.Resource;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 扣减账户余额
     */
    @PostMapping("/account/reduce")
    public Result result(@RequestParam("userId") Long userId, @RequestParam("money") Integer money) {
        accountService.reduce(userId, money);
        return Result.success("200", "扣减账户余额 OK");
    }

}
