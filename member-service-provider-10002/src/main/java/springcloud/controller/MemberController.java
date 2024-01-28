package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springcloud.entity.Member;
import springcloud.entity.Result;
import springcloud.service.MemberService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class MemberController {
    @Resource
    private MemberService memberService;


    @PostMapping("/member/save")
    //如果前端是以表单形式提交则不需要@RequestBody
    //如果前端以json格式提交，则需要@RequestBody
    public Result save(@RequestBody Member member) {
        log.info("service-provider-memeber={}", member);
        int effected = memberService.save(member);
        if (effected > 0) {
            //添加成功
            return Result.success("添加会员成功", effected);
        } else {
            return Result.error("401", "添加会员失败");
        }
    }


    //查询接口
    @GetMapping("/member/getMemberById/{id}")
    //如果前端是以表单形式提交则不需要@RequestBody
    //如果前端以json格式提交，则需要@RequestBody
    public Result getMemberById(@PathVariable("id") Long id) {
//        try {
//            TimeUnit.MILLISECONDS.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Member member = memberService.queryMemberById(id);
        if (member != null) {
            //添加成功
            return Result.success("查询成功-provider-10002", member);
        } else {
            return Result.error("402", "查询失败");
        }
    }

}
