package api.inter;

// CC를 이용하여 BB를 동작시키는 프로그래밍 (인터페이스 기반의 프로그래밍)
public class InterfaceAPI {

    public static void main(String[] args) {
        var cc = new BB();
        cc.x();
        cc.y();
        cc.z();

        CC c = new BB();
        c.x();
        c.y();
        c.z();
    }
}
