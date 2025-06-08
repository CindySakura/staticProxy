package order.bean;

import lombok.Data;
import product.bean.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * 功能：
 * 作者：Cindy
 * 日期：26/04/2025 00:29
 */
@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> productList;

}
