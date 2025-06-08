package order;

import order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 功能：
 * 作者：Cindy
 * 日期：08/06/2025 23:00
 */
@SpringBootTest
public class WeatherTest {

    @Autowired
    WeatherFeignClient weatherFeignClient;

    @Test
    void test(){
        String weather = weatherFeignClient.getWeahter("APPCODE 93b7e19861a24c519a7548b17dc16d75",
                "50b53ff8dd7d9fa320d3d3ca32cf8ed1","2182");
        System.out.println("weather = " + weather);

    }
}
