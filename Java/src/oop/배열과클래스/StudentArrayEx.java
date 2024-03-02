package oop.배열과클래스;

public class StudentArrayEx {
    private String name;
    private Integer age;
    private String phone;
    private String address;

    public StudentArrayEx(String name, Integer age, String phone, String address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentArrayEx{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
