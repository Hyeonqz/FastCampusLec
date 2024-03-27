package Stream;

import java.util.Arrays;

public class StreamApiTest {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5};

		int sumOfEvens = Arrays.stream(numbers)
			.filter(n -> n % 2 == 0)
			.sum();

		System.out.println(sumOfEvens);

		int[] evenNumbers = Arrays.stream(numbers)
			.filter(n -> n % 2 == 0)
			.toArray();

		System.out.println(evenNumbers);
	}
}
