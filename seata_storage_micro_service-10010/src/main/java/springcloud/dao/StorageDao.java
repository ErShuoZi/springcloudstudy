package springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    public void reduce(@Param("productId") Long productId,@Param("nums")Integer nums);
}
