package api.utility;

public class MyObjectTest {
    public static void main(String[] args) {
        // A,B,C 객체를 뱌열에 저장하고 출력해보기. -> Object[] 다형성 배열을 사용하기.

        var list = new ObjectArray();
        list.add(new A()); // Object element = new A(); -> UpCasting 이다.
        list.add(new B());
        list.add(new C());

        A a = (A)list.get(0);
        a.display();
        B b = (B)list.get(1);
        b.display();
        C c = (C)list.get(2);
        c.display();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof A) {
                ((A)list.get(i)).display();
            }
        }


    }
}
