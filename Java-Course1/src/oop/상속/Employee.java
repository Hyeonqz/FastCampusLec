package oop.상속;

import java.sql.Timestamp;

public class Employee extends Object{
    private String name;
    private int age;
    private String phone;
    private String empDate;
    private String dept;
    private boolean marriage;

    public Employee() {
        super(); // 상위 클래스의 생성자를 호출 하는 것이다.
    }

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

    public String getEmpDate() {
        return empDate;
    }

    public void setEmpDate(String empDate) {
        this.empDate = empDate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public boolean isMarriage() {
        return marriage;
    }

    public void setMarriage(boolean marriage) {
        this.marriage = marriage;
    }

    public Employee(String name, int age, String phone, String empDate, String dept, boolean marriage) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.empDate = empDate;
        this.dept = dept;
        this.marriage = marriage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", empDate=" + empDate +
                ", dept='" + dept + '\'' +
                ", marriage=" + marriage +
                '}';
    }
}
