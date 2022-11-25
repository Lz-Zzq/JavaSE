package set;

import sun.awt.image.ImageWatched;

import java.util.*;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        /*
        LinkedHashSet 是HashSet的子类 LinkedHashSet的底层维护的是LinkedHashMap 数组+双向链表
        LinkedHashSet 根据元素的hashCode值来决定元素存储的位置,同时使用链表来保持元素的顺序,使得元素看起来是插入保存的
        LinkedHashSet 是不允许保存重复元素   底层是LinkedHashMap$Entry  而不是HashMap$Node  静态内部类Entry继承Node
         */

        Set<Car> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(new Car("奥托",1000));
        linkedHashSet.add(new Car("奥迪",300000));
        linkedHashSet.add(new Car("法拉利",10000000));
        linkedHashSet.add(new Car("奥迪",300000));
        linkedHashSet.add(new Car("保时捷",70000000));
        linkedHashSet.add(new Car("奥迪",300000));

        System.out.println(linkedHashSet);





    }
}

//相同元素,不允许添加
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}