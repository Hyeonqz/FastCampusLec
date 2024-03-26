package generic;

public class AverageTest {
	public static void main(String[] args) {
		Integer[] integers = {1, 2, 3, 4, 5};
		Double[] doubles = {1.0, 2.0, 3.05, 4.1};

		AverageCalculator<Integer> integerAverageCalculator = new AverageCalculator<>(integers);
		double integerAverage = integerAverageCalculator.calculateAverage();
		System.out.println(integerAverage);
	}
}
