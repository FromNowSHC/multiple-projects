package proxy;

/**
 * @author shc
 * @date 2018-04-19
 **/
public class CatUtil {

    public static void beforeMethod(){
        System.out.println("=====方法调用前=====");
    }

    public static void afterMethod(){
        System.out.println("=====方法调用后=====");
    }

}
