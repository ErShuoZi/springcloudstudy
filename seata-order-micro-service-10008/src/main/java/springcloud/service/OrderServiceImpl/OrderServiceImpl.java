package springcloud.service.OrderServiceImpl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springcloud.dao.OrderDao;
import springcloud.entity.Order;
import springcloud.service.AccountService;
import springcloud.service.OrderService;
import springcloud.service.StorageService;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    /**
     *     @GlobalTransactional(name = "ls-save-order",rollbackFor = Exception.class)
     *     分布式全局事务控制
     *     name = "ls-save-order" 自定义，注意唯一性
     *     rollbackFor = Exception.class： 指定发生什么异常就回滚
     */
    @Override
    @GlobalTransactional(name = "ls-save-order",rollbackFor = Exception.class)
    public void save(Order order) {
        log.info("=========开始新建订单 start ==========");
        //新建订单
        orderDao.save(order);
        log.info("=========减库存 start ==========");
        storageService.reduce(order.getProductId(), order.getNums());
        log.info("=========减库存 end ==========");
        log.info("=========减账户金额 start ==========");
        accountService.reduce(order.getUserId(), order.getMoney());
        log.info("=========减账户金额 end ==========");

        log.info("=========修改订单状态 start ==========");
        orderDao.update(order.getUserId(), 0);
        log.info("=========修改订单状态 end ==========");
        log.info("=========下订单 end==========");
    }
}
