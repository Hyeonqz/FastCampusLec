package api.utility;

import java.util.Random;

public class RandomAPI {
    public static void main(String[] args) {

        // nextInt(10) -> 0이상 10 미만의 난수를 반환
        // 배열에는 중복이 되면은 안됌 -> 중복안되는 컬렉션 or 중복 안되게 만드는 로직.
        Random random = new Random();
        var arr = new int[7];
        int i = 0; // 저장 위치

        while (i<7) {
            int inputNum = random.nextInt(45)+1; //+1을 해야 0부터 시작이 아닌 1부터 시작한다.
            boolean isDuplicated = false;
            for (int j = 0; j < i ; j++) {
                if (arr[i] == inputNum) {
                    isDuplicated=true;
                    break;
                }
            }
            if (!isDuplicated) {
                arr[i++] = inputNum;
            }
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
