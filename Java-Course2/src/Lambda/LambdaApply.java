package Lambda;

@FunctionalInterface
interface StringOper {
	String apply(String s);
}

public class LambdaApply {
	public static void main(String[] args) {

		// EX1
		StringOper toUpperCase = s -> s.toUpperCase();
		// EX2
		StringOper toUpperCase2 = String::toUpperCase;

		StringOper toLowerCase = s -> s.toLowerCase();

		String input = "Lambda Expressions";
		System.out.println(processString(input, toUpperCase));

	}

	public static String processString(String input, StringOper stringOper) {

		return stringOper.apply(input);
	}
}
