package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springcloud.entity.Member;
import springcloud.entity.Result;
import springcloud.service.MemberService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    public Result getMemberById(@PathVariable("id") Long id, HttpServletRequest request){
//        String color = request.getParameter("color");
        //模拟超时
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("当前线程id=" + Thread.currentThread().getId() + "时间" + new Date());
        Member member = memberService.queryMemberById(id);
        if(member != null) {
            //添加成功
//            return Result.success("查询成功-provider-10000-color" + color,member);
            return Result.success("查询成功-provider-Nacos-10004",member);
        } else {
            return  Result.error("402","查询失败");
        }
    }


//    @GetMapping(value = "/member/getMemberById", params = "id")
//    //如果前端是以表单形式提交则不需要@RequestBody
//    //如果前端以json格式提交，则需要@RequestBody
//    public Result getMemberById(Long id) {
//
//        Member member = memberService.queryMemberById(id);
//        if (member != null) {
//            //添加成功
////            return Result.success("查询成功-provider-10000-color" + color,member);
//            return Result.success("查询成功-provider-Nacos-10004", member);
//        } else {
//            return Result.error("402", "查询失败");
//        }
//    }


    @GetMapping("/t1")
    public Result t1() {
       return Result.success("t1执行");
    }

    @GetMapping("/t2")
    public Result t2() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("执行t2()线程={}",Thread.currentThread().getId());
        return Result.success("t2执行");
    }

}
