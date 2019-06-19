package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shc
 * @date 2018-04-19
 **/
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 逻辑处理，如日志打印等
        CatUtil.beforeMethod();
        Object result = method.invoke(target, args);
        CatUtil.afterMethod();
        return result;
    }
}
