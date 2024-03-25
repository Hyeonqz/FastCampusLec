package collection;

import java.util.HashSet;
import java.util.Set;

public class UniqueNumbers {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,7,4,5,8,13};

        Set<Integer> set = new HashSet<>();

        for (Integer a : numbers) {
            set.add(a);
        }

        for (Integer number : set) {
            System.out.print(number);
        }
    }
}
