package Functional;

public class PersonFactoryTest {
	public static void main(String[] args) {

		PersonFactory personFactory = new PersonFactory() {

			@Override
			public Person create(String name, int age) {
				return new Person(name, age);
			}
		};

	}
}
