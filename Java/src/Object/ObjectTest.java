package Object;

public class ObjectTest {
    public static void main(String[] args) {
        // ObjectEx 객체를 upCasting 으로 생성 -> 객체를 부모 타입으로 만드는 것
        var objectEx = new ObjectEx();
        objectEx.display();

        Object object = new ObjectEx();
        // 안됌 -> Object 객체는 자바에서 만들어 둔거기 때문에 그 클래스에는 내가 만들어둔 display가 없다


    }
}
