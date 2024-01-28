package springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayRoutesConfig {
//    @Bean
    public RouteLocator myRouteLocator02(RouteLocatorBuilder routeLocatorBuilder) {
//        routes: # 配置路由  List<RouteDefinition> routes
//                - id: member_route01 # 路由的id，唯一
//          # 匹配后提供服务的路由地址，也可是外网
//          # 如果根据路径匹配成功，最终转发的url:url = http://localhost:10000/member/getMemberById/**
//          # 如不成功则返回404错误
//          # uri 要从服务注册中心获取
//        uri: http://localhost:10000 # 服务提供方ip和端口
//        predicates: #断言，可以有多种形式的断言
//                - Path=/member/getMemberById/**
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocator memberRoute02 = routes.route("member_route02", r -> r.path("/member/getMemberById/**").uri("http://localhost:10000")).build();
        return memberRoute02;
    }
}
