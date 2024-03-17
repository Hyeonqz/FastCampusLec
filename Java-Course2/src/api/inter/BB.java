package api.inter;

// BB는 노출을 시키지 않는다. (컴파일된 BB.class)파일만 주고. (BB.java 파일은 주지 않는다) -> 그럼 어떻게 동작하냐? 인터페이스를 구현한 C를 동작시키는 것이다.
public class BB implements CC{
    @Override
    public void x() {
        System.out.println("x가 동작한다.");
    }

    @Override
    public void y() {
        System.out.println("y가 동작한다.");
    }

    @Override
    public void z() {
        System.out.println("z가 동작한다. ");
    }
}
