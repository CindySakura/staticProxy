package product.service.impl;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import product.bean.Product;
import product.service.ProductService;

/**
 * 功能：
 * 作者：Cindy
 * 日期：26/04/2025 00:06
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("99"));
        product.setProductName("苹果");
        product.setNum(2);

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return product;
    }
}
