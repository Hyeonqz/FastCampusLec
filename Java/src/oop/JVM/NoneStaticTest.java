package oop.JVM;

public class NoneStaticTest {
    public static void main(String[] args) {
        NoneStaticTest noneStaticTest = new NoneStaticTest();
        int a = 10;
        int b = 20;
        int sum = noneStaticTest.hap(a,b);
        System.out.println(sum);
    }
    public int hap(int a, int b) {
        return a+b;
    }
}
