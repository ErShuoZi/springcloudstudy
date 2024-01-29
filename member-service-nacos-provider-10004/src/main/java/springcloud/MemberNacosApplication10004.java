package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//引入Nacos发现注解
@EnableDiscoveryClient
public class MemberNacosApplication10004 {
    public static void main(String[] args) {
        SpringApplication.run(MemberNacosApplication10004.class,args);
    }
}
