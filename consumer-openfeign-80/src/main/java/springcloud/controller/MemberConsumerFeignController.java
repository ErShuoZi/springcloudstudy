package springcloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entity.Result;
import springcloud.service.MemberFeignService;

import javax.annotation.Resource;

@RestController
public class MemberConsumerFeignController {
    //装配Service
    @Resource
    private MemberFeignService memberFeignService;

    @GetMapping("/member/consumer/openfeign/getMemberById/{id}")
    public Result getMemberById(@PathVariable("id") Long id) {
        return memberFeignService.getMemberById(id);
    }
}
