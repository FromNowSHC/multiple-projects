package clone;

import java.io.Serializable;

/**
 * @author shc
 * @date 2020-03-22
 */
public class Birds  implements Serializable {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Birds{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
