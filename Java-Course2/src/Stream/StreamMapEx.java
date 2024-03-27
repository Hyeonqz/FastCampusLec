package Stream;

import java.util.Arrays;
import java.util.List;

public class StreamMapEx {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squaredNumbers = numbers.stream()
			.map(n -> n * n)
			.toList();
		System.out.println(squaredNumbers);

		List<String> words = Arrays.asList("apple", "banana", "grapes", "orange", "gyul");
		List<String> upper = words.stream()
			.map(s -> s.toUpperCase())
			.toList();

		System.out.println(upper);
	}
}
