package mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 功能：
 * 作者：Cindy
 * 日期：13/06/2024 00:15
 */
public class UserController {
    /**
     * 使用RESTFul模拟用户资源的增删改查
     * /user   GET     查询所有用户信息
     * /user/1 GET     根据用户id查询用户信息
     * /user   POST    添加用户信息
     * /user/1 DELETE  删除用户信息
     * /user   PUT     修改用户信息
     */

    @RequestMapping(value = "/user",method= RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }
}
