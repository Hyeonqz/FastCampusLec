package org.example.api;

public class SingleDigit {
	static int singleDigit(int n) {

		if (n < 10) {
			return n;
		}

		String result = Integer.toBinaryString(n);

		int sum = 0;

		for (int i = 0; i < result.length(); i++) {
			sum += Character.getNumericValue(result.charAt(i));
		}

		if(sum<10) {
			return sum;
		}
		else {
			return singleDigit(sum);
		}
	}
}

// 10진수 -> 2진수
// 2진수의 1 숫자가 1자리 수가 나올 때 까지 만든다.

class Kata {
	static int singleDigit(int n) {
		return n<10? n: singleDigit(Integer.bitCount(n));
	}
}