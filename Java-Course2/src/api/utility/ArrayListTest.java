package api.utility;

import java.awt.print.Book;
import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        // Book[], Object[]
        var list = new ArrayList<>(); //기본크기는 10개임

        list.add(new BookDTO("자바",15000,"한빛","진현규"));
        list.add(new BookDTO("스프링",20000,"금빛","김영한"));
        list.add(new BookDTO("JPA",25000,"은빛","권오흠"));
        list.add(new BookDTO("MySQL",35000,"동빛","박매일"));

        System.out.println(list.get(0));
    }
}
