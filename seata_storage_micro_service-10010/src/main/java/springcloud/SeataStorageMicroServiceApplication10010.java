package springcloud;

import io.seata.config.springcloud.EnableSeataSpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//取消数据源的自动配置，使用seata代理数据源
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableSeataSpringConfig
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageMicroServiceApplication10010 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMicroServiceApplication10010.class,args);
    }

}
