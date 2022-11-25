package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapSource {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("abc","abc");
        map.put("abc","123");
        for (int i = 0; i < 12; i++) {
            map.put(new A(i),"hello");
        }
    }
}

class A{
    private int a;

    public A(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a1 = (A) o;
        return a == a1.a;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}
