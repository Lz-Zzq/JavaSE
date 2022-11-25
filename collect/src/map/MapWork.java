package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapWork {
    public static void main(String[] args) {
        Map<String, Employee> map = new HashMap<>();
        map.put("000",new Employee("张三",20000));
        map.put("001",new Employee("王五",20000));
        map.put("002",new Employee("李四",10000));

        Set<Map.Entry<String, Employee>> entries = map.entrySet();
        for (Map.Entry<String, Employee> entry : entries) {
            if (entry.getValue().getWages() > 18000) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }


    }
}

class Employee{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", wages=" + wages +
                '}';
    }

    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

    private String name;
    private double wages;

    public Employee(String name,double wages) {
        this.name = name;
        this.wages = wages;
    }
}