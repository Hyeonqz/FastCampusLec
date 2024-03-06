package oop.상속;

import java.sql.Date;
import java.sql.Timestamp;

public class RempVO extends Employee{

    public RempVO() {
        super(); // 메모리에 먼저 Employee 객체가 생성이 됩니다.
    }
    // 상속을 받으면 부모 객체가 먼저 메모리에 올라가고
    // 그다음에 자식 객체가 메모리에 올라간다
    // 즉 자식객체는, 부모,자식 둘다 모든 필드를 사용할 수 있다.
    public static void main(String[] args) {
    RempVO rempVO = new RempVO();
    rempVO.setName("ㅎㅇ");
    rempVO.setAge(20);
    rempVO.setDept("개발");
    rempVO.setMarriage(true);
    rempVO.setPhone("010-1234-5678");
    }

}
