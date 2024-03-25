package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("banana");
        set.add("Apple");
        set.add("Apple");
        set.add("cherry");

        System.out.println(set.size());

        for (String s : set) {
            System.out.print(s + " ");
        }

        set.remove("banana");

        for (String s : set) {
            System.out.println(s + " ");
        }

        System.out.println(set.contains("cherry"));

        set.clear();

        boolean empty = set.isEmpty();
    }
}
