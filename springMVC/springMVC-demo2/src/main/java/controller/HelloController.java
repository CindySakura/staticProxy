package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

// @RequestMapping注解：处理请求和控制器方法之间的映射关系
// @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
// localhost:8080/springMVC/
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }

    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String toTestParam(HttpServletRequest request){
        String username = request.getParameter("username");
        String pw = request.getParameter("pw");
        System.out.println("username: " +username + " pw: "+ pw);
        return "success";
    }

    @RequestMapping("/testParam")
    //若请求参数中出现多个同名的请求参数，可以在控制器方法的形参位置设置字符串类型或字符串数组来接收此请求参数
    //若使用字符串类型：最终结果为请求参数的每一个值之间使用逗号进行拼接的
    
    public String testParam(@RequestParam(value = "user_name", required = false) String username,
                            String pw,
                            String[] hobby){
        System.out.println("username: " +username + " pw: "+ pw + " hobby: "+ Arrays.toString(hobby));
        return "success";
    }
}
