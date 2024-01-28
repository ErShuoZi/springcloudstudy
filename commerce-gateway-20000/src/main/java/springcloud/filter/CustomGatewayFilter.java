package springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Set;

//@Component
public class CustomGatewayFilter implements GlobalFilter, Ordered {
    //过滤业务
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取到对应的参数值
        ServerHttpRequest request = exchange.getRequest();
        String user = request.getQueryParams().get("user").get(0);
        String pwd = request.getQueryParams().get("pwd").get(0);
        if (!("ls".equals(user) && "123456".equals(pwd))){
            //不满足条件
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);

    }

    //Order表示过滤器执行的顺序,值越小,优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
