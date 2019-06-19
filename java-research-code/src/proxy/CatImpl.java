package proxy;


/**
 * @author shc
 * @date 2018-04-19
 **/
public class CatImpl implements Cat {
    @Override
    public void meow() {
        System.out.println("喵！喵！喵！喵！");
    }

    @Override
    public void run() {
        System.out.println("我的身法无人能敌!");

    }
}
