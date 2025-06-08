package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.bean.Product;
import product.service.ProductService;

/**
 * 功能：
 * 作者：Cindy
 * 日期：25/04/2025 23:55
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    //查询商品
    @RequestMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        System.out.println("hello");//对比每个服务的控制台是否打印hello以及打印的数量判断调用了哪个节点
        Product product = productService.getProductById(productId);
        return product;
    }
}
