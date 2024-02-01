package springcloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
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
    public Result reduce(Long productId, Integer nums) {
        service.reduce(productId, nums);
        return Result.success("扣减库存成功 ok", null); }
}
