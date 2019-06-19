package proxy;

/**
 * Proxy测试类
 *
 * @author shc
 * @date 2018-04-19
 **/
public class MyProxyTest {

    public static void main(String[] args) {

        Cat cat = new CatImpl();
        Cat proxyCat = (Cat) MyProxyFactory.getProxy(cat);
        proxyCat.meow();
        proxyCat.run();

    }


}
