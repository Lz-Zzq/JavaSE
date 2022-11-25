package set;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class HashSetStructure {
    public static void main(String[] args) {
        //模拟一个HashSet的地城(HashMap 的底层结构)


        //1.创建一个数组,数组的类型是 Node[]
        Node[] nodes = new Node[22];
        Node john = new Node("john", null);
        nodes[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack;
        Node marry = new Node("marry", null);
        jack.next = marry;
        Node rose = new Node("Rose", null);
        nodes[3] = rose;
        System.out.println(nodes);

        Set<String> set = new HashSet();
        set.add("a");
    }
}

class Node{
    String name;
    Object next;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Node(String name, Object next) {
        this.name = name;
        this.next = next;
    }

    public Node() {
    }
}
