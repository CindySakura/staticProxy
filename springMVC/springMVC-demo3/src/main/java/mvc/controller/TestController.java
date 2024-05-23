package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能：
 * 作者：Cindy
 * 日期：30/04/2024 01:16
 */
@Controller
//专门实现页面跳转的
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("test_view")
    public String test_view(){
        return "test_view";
    }
}
