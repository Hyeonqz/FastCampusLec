package Lambda;

import Functional.MathOperation;

public class LambdaEx {
	public static void main(String[] args) {
		// 익명 함수
		MathOperation add = new MathOperation() {
			@Override
			public int operation(int x, int y) {
				return x + y;
			}
		};

		// 익명 함수 -> 람다식
		MathOperation add1 = (x, y) -> {
			return x + y;
		};
		// 2
		MathOperation add2 = (x, y) -> x + y;
		// 3
		MathOperation add3 = Integer::sum;

	}
}
