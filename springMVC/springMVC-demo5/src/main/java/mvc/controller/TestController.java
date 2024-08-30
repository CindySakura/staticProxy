package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能：
 * 作者：Cindy
 * 日期：31/08/2024 00:41
 */
@Controller
public class TestController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
}
