package order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="weather-client",url="http://aliv18.data.moji.com")
public interface WeatherFeignClient {

    //postMapping中的值是请求路径
    @PostMapping("/whapi/json/alicityweather/condition")
    //RequestHeader，放到请求头中名字为Authorization地方，RequestParam，放在请求参数中参数名为token，city的地方
    String getWeahter(@RequestHeader("Authorization") String path,
                      @RequestParam("token") String token,
                      @RequestParam("cityId") String cityId);

}
