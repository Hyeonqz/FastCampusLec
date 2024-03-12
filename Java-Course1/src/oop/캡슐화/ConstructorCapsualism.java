package oop.캡슐화;

public class ConstructorCapsualism {
    private Long id;
    private String name;
    private Integer age;

    public ConstructorCapsualism(Long id) {
        this.id = id;
    }

    public ConstructorCapsualism(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ConstructorCapsualism(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String toString() {
        return name + "\t" + age + "\t" + id;
    }
}
