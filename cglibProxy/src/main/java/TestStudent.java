import interceptor.CglibInterceptor;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import service.IStudentService;
import service.impl.IStudentServiceImpl;
import transaction.Transaction;

public class TestStudent {
    //因为 JDK 8 中有关反射相关的功能自从 JDK 9 开始就已经被限制了，为了兼容原先的版本，
    //需要在运行项目时添加 --add-opens java.base/java.lang=ALL-UNNAMED 选项来开启这种默认不被允许的行为
    //但单元测试里改不成功，所以最后用了Main方法
    @Test
    public void testSave(){
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
