package interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import transaction.Transaction;
import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {
    //增强类对象
    private Transaction transaction;

    public CglibInterceptor(Transaction transaction){
        this.transaction = transaction;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //事务增强
        transaction.before();
        Object ret = methodProxy.invokeSuper(o, objects);
        //事务增强
        transaction.after();
        return ret;
    }
}
