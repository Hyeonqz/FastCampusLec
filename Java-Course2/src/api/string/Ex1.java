package api.string;

public class Ex1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str5 = "abcd";

        String str3 = new String("abc");
        String str4 = new String("abc");

        //System.out.println(str3==str4);
        //System.out.println(str3.equals(str4));

        System.out.println();

        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str5));

        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);

    }
}
