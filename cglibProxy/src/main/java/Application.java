import interceptor.CglibInterceptor;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import service.IStudentService;
import service.impl.IStudentServiceImpl;
import transaction.Transaction;

public class Application {
    public static void main(String[] args) {
        //生成目标代理类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"src\\");
        //得到方法拦截器
        CglibInterceptor interceptor = new CglibInterceptor(new Transaction()); //Transaction 增强类对象
        //使用CGLIB框架生成目标类的子类（代理类）实现增强
        Enhancer enhancer = new Enhancer();
        //设置父类字节码
        enhancer.setSuperclass(IStudentServiceImpl.class);
        //设置拦截处理
        enhancer.setCallback(interceptor);
        IStudentService studentService = (IStudentService) enhancer.create();
        studentService.save();
    }
}
