package order.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 功能：
 * 作者：Cindy
 * 日期：26/04/2025 14:53
 */
@Configuration
public class OrderConfig {
    @LoadBalanced//注解式负载均衡
    @Bean
    //Order服务调用别的微服务
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 开启feign日志
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
