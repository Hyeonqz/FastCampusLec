package api.utility;

public class MyIntArrayTest {
    public static void main(String[] args) {
        // 정수 3개를 배열에 저장하고 출력하세요.
        IntArray intArray = new IntArray();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);

        System.out.println(intArray.get(1));
        System.out.println(intArray.size());

    }
}
