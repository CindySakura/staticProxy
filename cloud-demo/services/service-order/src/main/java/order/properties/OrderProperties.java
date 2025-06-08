package order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 功能：
 * 作者：Cindy
 * 日期：26/04/2025 22:32
 */
@Component //该bean一定要是容器中的组件这个配置才能生效，所以要加Component使ConfigurationProperties生效
@ConfigurationProperties("order") //配置批量绑定在nacos下，可以无需@RefreshScope就能实现自动刷新
@Data
public class OrderProperties {
    String timeout;
    String autoConfirm; //auto-confirm:-c在Java中转成驼峰
    //不同配置文件但是同一Group同一前缀可以进行批量绑定
    String dbUrl;
}
