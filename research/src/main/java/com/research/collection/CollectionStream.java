package com.research.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shc
 * @date 2020-01-11
 */
public class CollectionStream {

    public List<Person> data() {
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person(200, "半人马行者"));
        listPerson.add(new Person(50, "莉娜"));
        listPerson.add(new Person(100, "斯达拉"));
        listPerson.add(new Person(80, "熊战士"));
        listPerson.add(new Person(500, "末日使者"));
        listPerson.add(new Person(18, "米拉娜"));
        return listPerson;
    }


    public void foreach() {
        List<Person> data = data();
        data.forEach(person -> person.name = "DOTA2:" + person.name);
        System.out.println(data);
    }

    /**
     * 过滤保留返回true的数据
     */
    public void filter() {
        List<Person> data = data();
        data = data.stream().filter(person -> person.age > 20).collect(Collectors.toList());
        System.out.println(data);
        data = data.stream().filter(person -> {
            if (person.age > 250) {
                person.name = "古老的力量正在苏醒";
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        System.out.println(data);
    }


    public void map() {
        List<Person> data = data();
        data.stream().map(Person::getName).collect(Collectors.toList());
    }

    /**
     * 集合的合并
     */
    public void flatMap() {
        List<Person> data = data();
        List<List<Person>> lists = new ArrayList<>();
        lists.add(data);
        lists.add(data);
        lists.add(data);
        lists.add(data);
        // 将所有集合合并成一个集合
        data = lists.stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());
        System.out.println(data);
    }

    /**
     * 将集合转换成map
     */
    public void toMap() {
        List<Person> personList = data();
        Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getName,
                Function.identity(), (oldValue, newValue) -> newValue));
        System.out.println(personMap);
    }

    /**
     * 累积处理
     */
    public void reduce() {
        List<Person> data = data();
        data.stream().map(Person::getAge).reduce((x, y) -> x + y);
        Integer result = data.stream().map(Person::getAge).reduce(0, (x, y) -> x+y);
        System.out.println(result);
    }


    public static void main(String[] args) {


    }

}
