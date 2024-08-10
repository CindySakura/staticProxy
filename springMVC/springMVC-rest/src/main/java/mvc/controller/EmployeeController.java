package mvc.controller;

import mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 功能：
 * 作者：Cindy
 * 日期：10/08/2024 22:18
 */
@Controller
public class EmployeeController {
    @Autowired//默认根据byType 其次byName Resource 默认 byName, 如果byName找不到才 byType，Autowired 根据类型装配，想要根据名称需要配合 Qualifier
    private EmployeeDao employeeDao;
}
