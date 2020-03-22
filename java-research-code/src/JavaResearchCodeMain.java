import clone.Birds;
import clone.ClassClone;

/**
 * @author shc
 * @date 2018-07-13
 **/
public class JavaResearchCodeMain {

    public static void main(String[] args){

        ClassClone classClone = new ClassClone();
        Birds birds = new Birds();
        birds.setAge(2);
        birds.setName("麻雀");
        classClone.setBirds(birds);
        classClone.setName("深克隆");

        ClassClone classClone1 = classClone.deepClone();
        classClone1.getBirds().setName("布谷鸟");

        System.out.println(classClone.toString());
        System.out.println(classClone1.toString());

    }

}
