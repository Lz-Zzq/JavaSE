package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetCRUD {
    public static void main(String[] args) {
        //去重,无序,可写入null
        //取出的顺序是固定的
        Set<Object> hashSet = new HashSet<Object>();
        //add返回boolean值
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<Object> objects1 = new ArrayList<>();
        objects.add("a");
        objects.add("a");
        objects1.add("a");
        System.out.println(objects1.equals(objects));


        /*
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        //定义了辅助变量
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //table就是HashMap的一个数组,类型是Node[] if语句表示成立则是第一次扩容到16单位
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //根据Hash 去计算该key应该存放到table表的哪个位置,并把这个位置的对象,赋值给P
        //判断p 是否为null  如果为null表示还没有存放元素,就创建一个Node(key = "java",value=PRESENT)

        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
        //需要局部变量时候在创建是比较好的
            Node<K,V> e; K k;
            //如果当前索引位置对应的链表的第一个元素和准备添加的key的hash值一样的
            //并且满足其一:
            //1.) 准备加入的 key 和 p 指向的 node 的节点的 key 是同一个对象
            //2.) p 指向 node 节点的 key 的equals() 方法和准备加入的key比较之后相同
            //总结: 如果是相同的对象 或者是相同的值(String) 或者程序员重写equals()相同 都无法加入
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //然后在判断是否为一颗红黑树
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            //如果table对应的索引位置,已经是一个链表,就是用for循环进行比较
            1.) 依次和该链表的每一个链表比较后都不先相同,说明添加的这个元素是没有重复的
            //将元素添加到链表中后,立刻判断是否为8个元素,是则直接 调用treeifyBin() 转换为红黑树
            //再转换成红黑树之前,要进行判断
            // 判断条件:
            if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                 resize();
            // 如果上面条件成立,就进行对table表的扩容
            // 如果不成立,才会转换成为红黑树
            2.) 如果有相同的情况就直接break
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
         */

    }
}
