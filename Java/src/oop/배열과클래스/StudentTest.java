package oop.배열과클래스;

public class StudentTest {
    public static void main(String[] args) {
    // Q. 정수 6개를 저장할 배열을 생산
    int[] arr = new int[6];
    arr[0] = 10;
    arr[1] = 30;
    arr[2] = 67;
    arr[3] = 55;
    arr[4] = 98;
    arr[5] = 32;

    // 자바에서 배열은 객체로 취급한다

    for (int i = 0; i <arr.length ; i++) {
        System.out.println(arr[i]);
    }

        System.out.println();

    StudentVO studentVO = new StudentVO("홍길동",20,"컴공","bitcoin@upbite.com",24,"1234-5678");
        System.out.println(studentVO.toString());







    }
}
