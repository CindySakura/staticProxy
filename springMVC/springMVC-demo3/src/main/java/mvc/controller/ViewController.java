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

    @RequestMapping("testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    @RequestMapping("testRedirect")
    public String testRedirect(){
        //重定向到一个请求，而不是一个页面
        //因为重定向无法访问web inf目录下的html页面
        //并且现在的页面都需要通过thymeleaf解析，所以只能通过转发来访问Thymeleaf
        return "redirect:/testThymeleafView";
    }
}
