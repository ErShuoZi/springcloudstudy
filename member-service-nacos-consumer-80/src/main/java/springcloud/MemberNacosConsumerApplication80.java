package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import springcloud.config.RibbonConfig;


@SpringBootApplication

@EnableDiscoveryClient  //启用服务发现
@RibbonClient(name = "MEMBER-SERVICE-NACOS-PROVIDER",configuration = RibbonConfig.class)
public class MemberNacosConsumerApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(MemberNacosConsumerApplication80.class,args);
    }
}
