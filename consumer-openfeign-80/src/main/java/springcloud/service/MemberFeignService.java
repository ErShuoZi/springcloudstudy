package springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springcloud.entity.Result;


@Component
@FeignClient(value = "MEMBER-SERVICE-PROVIDER")
public interface MemberFeignService {

    //这里定义方法-就是远程调用的接口
    /*
        1.远程调用方式是get
        2.远程调用的url
        3.openfeign默认是轮询调用
     */
    @GetMapping("/member/getMemberById/{id}")
    //如果前端是以表单形式提交则不需要@RequestBody
    //如果前端以json格式提交，则需要@RequestBody
    public Result getMemberById(@PathVariable("id") Long id);
}
