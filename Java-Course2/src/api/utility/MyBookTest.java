package api.utility;

public class MyBookTest {
    public static void main(String[] args) {
        var bookArray = new BookArray();
        bookArray.add(new BookDTO("자바",15000,"한빛","진현규"));
        bookArray.add(new BookDTO("스프링",20000,"금빛","김영한"));
        bookArray.add(new BookDTO("JPA",25000,"은빛","권오흠"));
        bookArray.add(new BookDTO("MySQL",35000,"동빛","박매일"));

        System.out.println(bookArray.get(0));
        System.out.println(bookArray.get(1));
        System.out.println(bookArray.get(2));
        System.out.println(bookArray.get(3));
    }
}
