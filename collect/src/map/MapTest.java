package map;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        //k-v 最后是HashMap$Node node = newNode(hash,key,value,null)
        //k-v 为了方便程序员的遍历,还会创建EntrySet 集合,该集合存放的元素类型Entry
        //而一个Entry对象就有k,v EntrySet<Entry<K,V>> 即: transient Set<Map.Entry<K,V>> entrySet;
        //entrySet中,定义的类型是Map.Entry,但是实际上存放的还是HashMap$Node
        //这时因为 static class Node<K,V> implements map.Map.Entry<K,V>



        /*
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        //创建变量用于使用
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //判断底层table数组为null,或者length为0,就栝容到16(第一次扩容)
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //取出hash值对应的table的索引位置的node 如果为null 就直接把加入的k-v创建成为一个node加入到该节点
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;  //辅助变量
            //如果table的索引位置的key的hash值和新的key的hash值相同,并且满足是一个对象或者内容相同(equals)
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)  //如果当前的table已有的node是红黑树,就按照红黑树的方式处理
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            //找到的节点如果是链表,那么就循环比较,死循环
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) { //如果整个链表,没有和他相同就加入到该链表的最后
                        p.next = newNode(hash, key, value, null);
                        //加入完毕后,判断当前链表的个数,如果到8,就进行树化转化  (需要数组长度size到达64)
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&   //循环比较发现相同,直接break退出
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                //替换key对应的value值
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;  //记录长度
        //判断是否到达临界值,到达临界值就扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

    //如果table为null ,或者长度没有到达64,暂时不树化,先进行扩容
    //剪枝,这种情况红黑树数据被删除,删除到一定长度就会转换成为链表
    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
         */

        Map<Object,Object> map = new HashMap<>();
        map.put("第一",1);
        map.put("第一1",2);
        map.put("第一2",2);
         map.put("第一22",2);
        map.put("第一3",2);
        map.put("第一4",2);
        map.put("第一5",2);
        map.put("第一6",2);
        map.put("第一7",2);
        map.put("第一8",2);
        map.put("第一9",2);
        map.put("第一0",2);
        map.put("第一01",2);
        map.put("第一021",2);
        map.put("第一101",2);
        map.put("第一013",2);
        map.put("第一011",2);

        //第一种增强for循环
        //获取所有的key
        Set<Object> set = map.keySet();
        for (Object key : set) {
            System.out.println(key + " = " + map.get(key));
        }

        System.out.println("-----------------------------");
        //第二种迭代器
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            System.out.println(key + " = " + map.get(key));
        }

        //将所有的value取出
        //迭代器与增强for 省略

        System.out.println("-------------------------------");
        //通过EntrySet来获取
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + " = " +entry.getValue());
        }

        System.out.println("--------------------------------");

        Iterator<Map.Entry<Object, Object>> iterator1 = entries.iterator();
        while (iterator1.hasNext()){
            Map.Entry<Object, Object> next = iterator1.next();
            System.out.println(next.getClass());
            System.out.println(next.getKey() + " = " + next.getValue());
        }


    }
}
