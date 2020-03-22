package clone;

import java.io.*;

/**
 * 利用流的方式实现深克隆
 * 要求目标类中的类型都要实现Serializable
 *
 * @author shc
 * @date 2020-03-22
 */
public class ClassClone implements Serializable {

    private String name;

    private Birds birds;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Birds getBirds() {
        return birds;
    }

    public void setBirds(Birds birds) {
        this.birds = birds;
    }

    @Override
    public String toString() {
        return "ClassClone{" +
                "name='" + name + '\'' +
                ", birds=" + birds +
                '}';
    }

    public ClassClone deepClone() {
        ClassClone classClone = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            classClone = (ClassClone) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return classClone;
    }
}
