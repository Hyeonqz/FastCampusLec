package collection;

public class WrapperTest {
    public static void main(String[] args) {
        // 정수형 변수에 10을 저장
        int a = 10;
        Integer aa = 10; //auto-boxing
        System.out.println(aa.intValue());

        Integer bb = null; // auto-boxing
        int b= bb; // auto-unboxing

        float f = 10.5f;
        Float ff = 45.6f;
        System.out.println(ff.floatValue());


    }
}
