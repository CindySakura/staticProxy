import handler.TransactionHandler;
import org.junit.Test;
import service.IStudentService;
import service.impl.IStudentServiceImpl;
import transaction.Transaction;

import java.lang.reflect.Proxy;

public class TestStudent {
    @Test
    public void testSave(){
        //增强类对象
        Transaction transaction = new Transaction();
        //目标执行类
        IStudentServiceImpl studentService = new IStudentServiceImpl();
        //方法拦截处理器
        TransactionHandler th = new TransactionHandler(transaction,studentService);
        //获取代理实例对象
        IStudentService proxyStudentService = (IStudentService)Proxy.newProxyInstance(IStudentServiceImpl.class.getClassLoader(),
                IStudentServiceImpl.class.getInterfaces(),
                th);
        proxyStudentService.save();
        proxyStudentService.query();
    }
}
