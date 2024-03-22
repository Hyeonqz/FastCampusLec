package collection;

public class WrapperTest {
    public static void main(String[] args) {
        // 정수형 변수에 10을 저장
        int a = 10;
        Integer aa = null; //auto-boxing
        System.out.println(aa.intValue());

        Integer bb = null; // auto-boxing
        int b= bb; // auto-unboxing

        float f = 10.5f;
        Float ff = 45.6f;
        System.out.println(ff.floatValue());

        // 숫자 -> 문자
        String str = "123";
        int num = Integer.parseInt(str);

        // 정수 -> 문자
        int num1 = 123;
        String str1 = String.valueOf(num1);


    }
}
