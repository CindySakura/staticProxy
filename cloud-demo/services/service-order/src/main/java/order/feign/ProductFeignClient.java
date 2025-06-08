package order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import product.bean.Product;

@FeignClient(value = "service-product")//说明是一个Feign客户端，发送远程调用的客户端，调用的地址是微服务的名称services-Client
public interface ProductFeignClient {

    //mvc注解的两套使用逻辑
    //1.标注在Controller上，是接受这样的请求
    //2.标注在OpenFeign上，是发送这样的请求
    @GetMapping("product/{id}")
    Product getProductById(@PathVariable Long id);
}
