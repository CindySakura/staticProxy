package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能：
 * 作者：Cindy
 * 日期：30/04/2024 01:16
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
