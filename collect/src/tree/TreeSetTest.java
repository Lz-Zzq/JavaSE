package tree;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //以字符对应的ASCII码进行比较
                return o1.compareTo(o2);
            }
        });
        treeSet.add("asdf");
        treeSet.add("fdsa");
        treeSet.add("ghjk");
        treeSet.add("dews");
        System.out.println(treeSet);

        /*
        //通过构造器传入 TreeSet底层是TreeMap
        public TreeSet(Comparator<? super E> comparator) {
            this(new TreeMap<>(comparator));
        }

        //将传递过来的comparator对象赋值给自己的comparator
        //注意: 比较规则会影响能否加入到集合种
        public TreeMap(Comparator<? super K> comparator) {
            this.comparator = comparator;
        }


        if (cpr != null) {
            do {
                parent = t;
                //动态绑定,可能会重写
                cmp = cpr.compare(key, t.key);
                //小于0放到左边
                if (cmp < 0)
                    t = t.left;
                //大于0放到右边
                else if (cmp > 0)
                    t = t.right;
                //等于0则覆盖
                else
                    return t.setValue(value);
            }
         */

    }
}
