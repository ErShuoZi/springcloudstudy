package springcloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entity.Result;
import springcloud.service.StorageService;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService service;

    //扣减库存
    @PostMapping("/storage/reduce")
    Result reduce(@RequestParam("productId") Long productId,
                  @RequestParam("nums") Integer nums) {
        System.out.println(productId);
        System.out.println(nums);
        System.out.println("#########################");
        service.reduce(productId, nums);
        return Result.success("扣减库存成功 ok", null);
    }
}
