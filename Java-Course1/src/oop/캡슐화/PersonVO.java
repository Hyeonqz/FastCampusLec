package oop.캡슐화;

public class PersonVO {
    private String name;
    private int age;
    private String phone;

    // 접근제어자 private으로 필드 변수를 선언해도
    // getter, setter 메소드를 통해서, 변수를 수정하고, 가져올 수 있다.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
