package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.entity.Member;
import springcloud.entity.Result;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class MemberConsumerController {
    //装配DiscoveryClient
    @Resource
    private DiscoveryClient discoveryClient;

    //装配 restTemplate
    @Resource
    private RestTemplate restTemplate;
    //定义member_service_provide 这是一个基础的url
//    public static final String MEMBER_SERVICE_PROVIDE = "http://localhost:10000";

    //MEMBER-SERVICE-PROVIDER 就是服务提供方[集群],注册到Eureka Server的名称，也就是服务提供方[集群]对外暴露的名称为MEMBER-SERVICE-PROVIDER
    //目前有两个Availability Zones   192.168.18.24:member-service-provider:10000 , 192.168.18.24:member-service-provider:10002
    //需要增加注解@LoadBalanced 赋予 restTemplate 负载均衡的能力

    public static final String MEMBER_SERVICE_PROVIDER = "http://MEMBER-SERVICE-PROVIDER";


    @PostMapping("/member/consumer/save")
    public Result<Member> save(Member member) {
        log.info("service-consumer-memeber={}",member);
        return restTemplate.postForObject(MEMBER_SERVICE_PROVIDER + "/member/save", member, Result.class);
    }


    @GetMapping("/member/consumer/getMemberById/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(MEMBER_SERVICE_PROVIDER + "/member/getMemberById/" + id,Result.class);
    }


    @GetMapping("/member/consumer/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务名={}", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
               log.info("实例id={},host={},port={},uri={}",instance.getInstanceId(),instance.getHost(),instance.getPort(),instance.getUri());
            }
        }
        return discoveryClient;
    }




}
