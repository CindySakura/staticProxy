package mvc.controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能：
 * 作者：Cindy
 * 日期：26/08/2024 21:21
 */
@Controller
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody: " + requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //当前RequestEntity表示整个请求报文的信息
        System.out.println("requestHeader: " + requestEntity.getHeaders());
        System.out.println("requestBody: " + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    //返回值void是因为这里不需要做页面跳转
    //使用原生ServletAPI
    public void testResponse(HttpServletResponse response) throws IOException {
        //打印的内容作为响应报文的响应体 响应到浏览器，所以响应体是什么 我们在浏览器中看到的就是什么
        response.getWriter().print("hello, response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody//加上responseBody的注解之后，return的内容就是响应到浏览器的响应体
    public String testResponseBody(){
        return "testResponseBody success";
    }

}
