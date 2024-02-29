package oop.캡슐화;

public class CapsualTest {
    public static void main(String[] args) {
        ConstructorCapsualism constructorCapsualism = new ConstructorCapsualism(10L,"Kyu",25);
        System.out.println(constructorCapsualism.toString());
        System.out.println(constructorCapsualism.hashCode());
        System.out.println(constructorCapsualism.getClass());
        System.out.println(constructorCapsualism.getAge() + "\t" + constructorCapsualism.getName() + "\t" + constructorCapsualism.getId());

        System.out.println(constructorCapsualism.toString());

    }
}
