package collection;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
    public static void main(String[] args) {
        String str = "Hello World!";

        Map<Character,Integer> charCountMap = new HashMap<>();
        var strArray = str.toCharArray();

        for (char c : strArray) {
            if ( charCountMap.containsKey(c)) {
                charCountMap.put(c,charCountMap.get(c)+1);
            } else {
                charCountMap.put(c,1);
            }
        }

        System.out.println("character counts");

        for ( char c : charCountMap.keySet()) {
            System.out.println(c + " : " + charCountMap.entrySet() + " : " + charCountMap.get(c));
        }


    }
}
