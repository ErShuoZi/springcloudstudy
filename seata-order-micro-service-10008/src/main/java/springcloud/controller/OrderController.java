package springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entity.Order;
import springcloud.entity.Result;
import springcloud.service.OrderService;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/save")
    public Result save(Order order) {
        System.out.println(order);
        orderService.save(order);
        return Result.success("订单创建成功", null);
    }
}
