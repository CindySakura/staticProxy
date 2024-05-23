package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能：
 * 作者：Cindy
 * 日期：23/05/2024 21:49
 */
@Controller
public class ViewController {
    @RequestMapping("testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }
}
