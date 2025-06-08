package order.service.impl;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import order.bean.Order;
import order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import product.bean.Product;

/**
 * 功能：
 * 作者：Cindy
 * 日期：26/04/2025 00:33
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired //一定导入spring-cloud-starter-loadbalancer
    LoadBalancerClient loadBalancerClient;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Product product = getProductFromRemote(productId);
        //Product product = getProductFromRemoteWithLoaderBalancer(productId);
        //Product product = getProductFromRemoteWithLoaderBalanceAnnotation(productId);
        Order order = new Order();
        order.setId(1L);
        //订单总金额 单价*数量
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("Cindy");
        order.setAddress("金融街");
        //远程查询商品列表
        order.setProductList(Arrays.asList(product));

        return order;
    }

    //远程获取商品信息
    private Product getProductFromRemote(Long productId){
        //1.获取到商品服务所在的所有机器IP+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance instance = instances.get(0);//缺点：每次都给固定的一个节点发送请求
        //拼接远程url：http://localhost:9000/product/4
        String url = "http://"+ instance.getHost() + ":" + instance.getPort()+"/product/" + productId;
        log.info("远程请求：{}", url);
        //2.给远程发送请求，远程返回的其实是Json，而我们这让他把Json自动转为JavaBean
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    //进阶2：完成负载均衡发送请求
    private Product getProductFromRemoteWithLoaderBalancer(Long productId){
        //1.获取到商品服务所在的所有机器IP+port
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        //拼接远程url：http://localhost:9000/product/4
        String url = "http://"+ choose.getHost() + ":" + choose.getPort()+"/product/" + productId;
        log.info("远程请求：{}", url);
        //2.给远程发送请求，远程返回的其实是Json，而我们这让他把Json自动转为JavaBean
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    //进阶3：基于注解的负载均衡
    private Product getProductFromRemoteWithLoaderBalanceAnnotation(Long productId){
        //拼接远程url：http://${微服务名称}/product/4，在发送请求前，会动态的把微服务的名称（service-product）负载均衡的替换成它的一个ip地址
        String url = "http://service-product/product/" + productId;
        log.info("远程请求：{}", url);//此时看url已经看不出来是否实现负载均衡
        //给远程发送请求，远程返回的其实是Json，而我们这让他把Json自动转为JavaBean
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }
}
