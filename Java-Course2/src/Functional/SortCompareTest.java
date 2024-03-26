package Functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCompareTest {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("진현규", "윤성환", "김연성");

		Collections.sort(names, String::compareTo);

		for (String name : names) {
			System.out.println(name);
		}
	}
}
