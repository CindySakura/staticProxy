package product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 功能：
 * 作者：Cindy
 * 日期：25/04/2025 23:55
 */
@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
