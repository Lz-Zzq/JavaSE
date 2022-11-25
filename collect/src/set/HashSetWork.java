package set;

import java.util.*;

public class HashSetWork {
    public static void main(String[] args) {
        Employee1 employee1 = new Employee1("张三","男",new MyData("2022","11","16"));
        Employee1 employee2 = new Employee1("张三","男",new MyData("2022","11","16"));
        Employee1 employee3 = new Employee1("张三","女",new MyData("2022","11","16"));
        Set<Employee1> hashSet = new HashSet<Employee1>();
        hashSet.add(employee1);
        hashSet.add(employee2);
        hashSet.add(employee3);
        for (Employee1 employee11 : hashSet) {
            System.out.println(employee11.toString());
        }
    }
}

class Employee1{
    private String name;
    private String sal;
    private MyData birthday;

    public Employee1(String name, String sal, MyData birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee1)) return false;
        Employee1 employee1 = (Employee1) o;
        return Objects.equals(name, employee1.name)
                && Objects.equals(sal, employee1.sal)
                && Objects.equals(birthday.getYear(), employee1.birthday.getYear())
                && Objects.equals(birthday.getMonth(), employee1.birthday.getMonth())
                && Objects.equals(birthday.getDay(), employee1.birthday.getDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sal, birthday.getYear(),birthday.getMonth(),birthday.getDay());
    }
}

class MyData{
    public MyData(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private String year;
    private String month;
    private String day;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}