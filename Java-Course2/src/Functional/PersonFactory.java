package Functional;

@FunctionalInterface
public interface PersonFactory {
	public Person create(String name, int age);
}
