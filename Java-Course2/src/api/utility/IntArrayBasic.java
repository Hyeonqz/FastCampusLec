package api.utility;

public class IntArrayBasic {
    public static void main(String[] args) {
        // 정수 5개를 배열에 저장하고 출력해보자
        var arr = new int[5]; // 배열 생성 동작 : 고정길이(단점) -> 가변길이 -> 컬렉션 프레임워크를 쓰자.
        arr[0] = 1; // 저장 동작(입력,추가)
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        for (int data : arr) {
            System.out.print(data + " ");
        }

    }
}
