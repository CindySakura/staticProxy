package order.controller;

import order.bean.Order;
import order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import order.properties.OrderProperties;

/**
 * 功能：
 * 作者：Cindy
 * 日期：26/04/2025 00:28
 */
@RefreshScope //自动刷新
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

//    @Value("${order.timeout}")
//    String orderTimeout;
//    @Value("${order.auto-confirm}")
//    String orderAutoConfirm;
    @Autowired
    OrderProperties orderProperties;

    //创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId){
        Order order = orderService.createOrder(productId, userId);
        return order;
    }

    @GetMapping("/config")
    public String config(){
        return "order.timeout=" + orderProperties.getTimeout() +
                "; order.auto-confirm=" + orderProperties.getAutoConfirm() +
                "; order.db-url="+ orderProperties.getDbUrl();
    }
}
