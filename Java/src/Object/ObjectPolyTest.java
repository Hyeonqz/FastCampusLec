package Object;

public class ObjectPolyTest {
    public static void main(String[] args) {

        var a = new ObjectA();
        printGo(a);
        var b = new ObjectB();
        printGo(b);
    }

    private static void printGo(Object obj) {
        if (obj instanceof ObjectA) {
           ((ObjectA) obj).printGo(obj);
        } else {
            ((ObjectB)obj).printGo(obj);
        }
    }
}
