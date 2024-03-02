package oop.배열과클래스;

public class StudentVO {
    private String name;
    private Integer age;
    private String dept;
    private String email;
    private Integer year;
    private String phone;

    public StudentVO(String name, Integer age, String dept, String email, Integer year, String phone) {
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.email = email;
        this.year = year;
        this.phone = phone;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", year=" + year +
                ", phone='" + phone + '\'' +
                '}';
    }
}
