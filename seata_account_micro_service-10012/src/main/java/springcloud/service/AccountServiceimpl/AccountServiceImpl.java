package springcloud.service.AccountServiceimpl;

import org.springframework.stereotype.Service;
import springcloud.dao.AccountDao;
import springcloud.service.AccountService;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;
    @Override
    public void reduce(Long userId, Integer money) {
        accountDao.reduce(userId,money);
    }
}
