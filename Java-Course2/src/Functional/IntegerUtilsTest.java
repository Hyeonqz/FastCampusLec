package Functional;

public class IntegerUtilsTest {
	public static void main(String[] args) {
		// 정적 메소드 참조
		Converter<String, Integer> converter = IntegerUtils::stringToInt;
		int result = converter.convert("100");
		System.out.println(result);
	}
}
