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
    // /**/testInterceptor ?表示一个字符 *表示一个或多个字符 **表示一层或多层目录
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
}
