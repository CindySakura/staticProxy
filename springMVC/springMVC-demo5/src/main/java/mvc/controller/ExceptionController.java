package mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 功能：
 * 作者：Cindy
 * 日期：02/09/2024 21:08
 */
@ControllerAdvice//用@Component标识的 是@Component的扩展组件 所以ControllerAdvice也有将类标识为组件的功能
public class ExceptionController {
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    /**
     * Exception表示当前出现的异常
     * 往请求域中共享数据：
     * 1.Servlet API
     * 2.ModelAndView （太长了
     * 3.Model
     * 4.Map （需要设置泛型
     * 5.ModelMap
     */
    public String testException(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
