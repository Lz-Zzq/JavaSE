package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListCRUD {
    public static void main(String[] args) {

        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        LinkedList<String> linkedList = new LinkedList<>();
        //双向链表 添加
        //直接将1 挂到尾部 如果头部当前指向null 那么同时头部也指向1
        linkedList.add("1");
        linkedList.add("1");
        linkedList.add("1");
        linkedList.add("1");
        //并且将当前对象设置为尾部节点,指向上一节点的尾部,之后在让上一节点头部指向当前对象
        linkedList.add("2");
        System.out.println("linkedList=" + linkedList);

        //删除
        Object remove = linkedList.remove();
        System.out.println("removeVal = " + remove);
        //获取第一个节点,随后让第一个节点成为GC回收的对象
        //值item指向null  next指向null

        //修改
        Object d = linkedList.set(0, "d");
        System.out.println("OldVal = " + d);

        //遍历   实现了List接口,遍历方式
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("linkedList=" + linkedList);



    }
}
