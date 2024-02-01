package springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springcloud.entity.Result;

@FeignClient(value = "seata-storage-micro-service-10010")
public interface StorageService {
    @PostMapping("/storage/reduce")
    public Result reduce(@RequestParam("productId") Long productId,
                  @RequestParam("nums") Integer nums);
}
