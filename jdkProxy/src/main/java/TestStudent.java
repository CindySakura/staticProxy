import handler.TransactionHandler;
import org.junit.Test;
import service.IStudentService;
import service.impl.IStudentServiceImpl;
import transaction.Transaction;
import javaapi.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        saveProxyClass("E:\\java project\\jdkProxy\\src\\");
    }

    /**
     * 使用来生成字节码(proxy代理类)学习使用
     * @param path
     */
    private void saveProxyClass(String path){
        //byte和$有关系？
        byte[] $proxy1s = ProxyGenerator.generateProxyClass("$Proxy1", IStudentServiceImpl.class.getInterfaces());
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(new File(path + "$Proxy1.class"));
            out.write($proxy1s);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(out != null){
                try{
                    out.flush();
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
