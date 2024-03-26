package Functional;

public class FunctionInterface2 {
	public static void main(String[] args) {
		// MathOperation 인터페이스를 내부 익명 클래스로 구현해보자.
		MathOperation mo = new MathOperation() {
			@Override
			public int operation(int x, int y) {
				return x + y;
			}
		}; // -> 익명 클래스
		int result = mo.operation(10, 30);
		System.out.println(result);

	}
}
