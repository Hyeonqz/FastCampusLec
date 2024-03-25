package collection;

import java.util.HashMap;
import java.util.Map;

public class MapEx {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("kim",90);
        map.put("park",80);
        map.put("jin",100);
        map.put("seong",99);
        map.put("choi",95);

        System.out.println("Kim's score : " + map.get("kim"));
        System.out.println("jin's score : " + map.get("jin"));

        map.put("jin",1000);
        System.out.println("jin's score : " + map.get("jin"));

        map.remove("seong");
        System.out.println("seong's score : " + map.get("seong"));

        for ( Map.Entry<String,Integer> entry : map.entrySet()) { // Key 만 뽑아오기
            System.out.println(entry.getKey());
        }


    }
}
