package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import springcloud.config.RibbonRule;

@SpringBootApplication
@RibbonClient(name = "MEMBER-SERVICE-PROVIDER",configuration = RibbonRule.class)
public class CommerceGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommerceGateWayApplication.class,args);
    }
}
