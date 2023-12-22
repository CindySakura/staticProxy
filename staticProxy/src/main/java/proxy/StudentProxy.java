package proxy;

import dao.Student;
import service.IStudentService;
import service.impl.IStudentServiceImpl;
import transaction.Transaction;

public class StudentProxy implements IStudentService {
    //目标类对象
    private IStudentServiceImpl studentService;
    //需要做的增强对象
    private Transaction transaction;
    //通过constructor获取目标类和增强类对象
    public StudentProxy(IStudentServiceImpl studentService, Transaction transaction) {
        this.studentService = studentService;
        this.transaction = transaction;
    }

    @Override
    public void save() {
        //开启事务操作
        transaction.before();
        //目标类操作
        studentService.save();
        //关闭事务操作
        transaction.after();
    }

    @Override
    public Student query() {
        studentService.query();
        return null;
    }
}
