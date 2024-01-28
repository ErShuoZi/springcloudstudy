package springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//配置类
@Configuration
public class CustomizationBean {
    //注入RestTemplate Bean
    @Bean
    @LoadBalanced //赋予restTemplate 负载均衡的能力，默认是轮询
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
