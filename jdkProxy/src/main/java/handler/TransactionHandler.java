package handler;

import transaction.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {
    //增强类对象
    private Transaction transaction;
    //需要代理的目标对象 接口类？
    private Object obj;

    public TransactionHandler(Transaction transaction,Object obj) {
        this.transaction = transaction;
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret;
        if("save".equals(method.getName())){
            transaction.before();
            ret = method.invoke(obj,args);
            transaction.after();
        }else{
            ret = method.invoke(obj,args);
        }
        return ret;
    }
}
