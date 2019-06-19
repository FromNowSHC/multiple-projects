package proxy;

import java.lang.reflect.Proxy;

/**
 * 代理工厂类
 *
 * @author shc
 * @date 2018-04-19
 **/
public class MyProxyFactory {

    /**
     * 生成的代理对象方法
     *
     * @param target 被代理的对象
     * @return Object 生成的代理对象
     */
    public static Object getProxy(Object target) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(target);
        // 返回代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), myInvocationHandler);
    }


}
