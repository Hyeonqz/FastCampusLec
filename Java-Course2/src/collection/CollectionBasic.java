package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectionBasic {
    public static void main(String[] args) {
        // ArrayList 에 10,20,30,40,50 정수를 저장
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        for (int data : list) {
            System.out.println(data);
        }

        var list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("banana");
        list1.add(1);


    }
}
