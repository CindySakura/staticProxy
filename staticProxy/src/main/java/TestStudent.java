import org.junit.Test;
import proxy.StudentProxy;
import service.impl.IStudentServiceImpl;
import transaction.Transaction;

public class TestStudent {
    @Test
    public void testSave(){
        IStudentServiceImpl studentService = new IStudentServiceImpl();
        Transaction transaction = new Transaction();
        //获取代理类对象
        //包含目标对象（实现类对象/被代理类对象）和前置通知和后置通知
        StudentProxy sp = new StudentProxy(studentService,transaction);
        sp.save();
        sp.query();
    }
}
