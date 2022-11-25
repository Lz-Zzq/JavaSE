package set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetExercise {
    /*
    定义一个employee类,该类包含 private name age
    要求:创建单个对象并且放入到HashSet中
    name与age值相同时候认为是同一个对象,不能添加到HashSet集合中

     */
    public static void main(String[] args) {
        Set<Object> hashSet = new HashSet<>();
        hashSet.add(new Employee("张三",23));
        hashSet.add(new Employee("张三",23));
        System.out.println(hashSet);

    }
}

class Employee{
    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Employee() {
    }

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

    private String name;
    private Integer age;

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Employee)) return false;
//        Employee employee = (Employee) o;
//        return Objects.equals(name, employee.name) && Objects.equals(age, employee.age);
//    }
}
