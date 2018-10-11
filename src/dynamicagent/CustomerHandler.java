package dynamicagent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomerHandler implements InvocationHandler{
    private Object target;//代理类实例
    public CustomerHandler(Object target){
        this.target=target;//传入代理类实例
    }
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result=method.invoke(target,args);//target为代理类实例,方法执行
        System.out.println("fore");
        return result;
    }
}
