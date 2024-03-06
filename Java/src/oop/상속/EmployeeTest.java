package oop.상속;

public class EmployeeTest {
    public static void main(String[] args) {

        // 일반 사원 한명의 객체를 생성하고 데이터를 저장후 출력하자
        RempVO rempVO = new RempVO("123",12,"123-123","123년123월123일","개발부서",false);
        // 출력
        System.out.println(rempVO.toString());

    }
}
