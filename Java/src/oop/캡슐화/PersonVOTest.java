package oop.캡슐화;

public class PersonVOTest {
    public static void main(String[] args) {
        PersonVO p = new PersonVO();
        p.setName("진현규");
        p.setAge(25);
        p.setPhone("010-1234-5678");

        System.out.println(p.toString());
        System.out.println(p.hashCode());
    }
}
