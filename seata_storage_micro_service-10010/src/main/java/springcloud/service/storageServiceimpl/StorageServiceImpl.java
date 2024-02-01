package springcloud.service.storageServiceimpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springcloud.dao.StorageDao;
import springcloud.service.StorageService;

import javax.annotation.Resource;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void reduce(Long productId, Integer nums) {
        log.info("==========seata_storage_micro_service-10010 扣 减 库 存start==========");
        storageDao.reduce(productId, nums);
        log.info("==========seata_storage_micro_service-10010 扣 减 库 存end==========");

    }
}
