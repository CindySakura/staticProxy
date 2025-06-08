package product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 功能：
 * 作者：Cindy
 * 日期：26/04/2025 14:42
 */
@Configuration
public class ProductServiceConfig {

    @Bean
    //Product服务调用别的微服务
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
