package set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashSetIncrement {
    public static void main(String[] args) {
        Map hashSet = new HashMap();
        hashSet.put("abc","abc");
        hashSet.put("abc","123");
        for (int i = 0; i < 100; i++) {
            hashSet.put(new A(i),"hello");
        }
    }
}

class A{
    private int n;
    public A(int i){}

    @Override
    public int hashCode() {
        return 100;
    }
}

