## 다형성(polymorphism)

### 다형성이란 무엇인가?
상위클래스가 동일한 메시지로 하위클래스를<br>
서로 다르게 동작 시키는 객체지향 이론

### 다형성이론을 설명하기 위한 전제조건

1) 상속관계
2) Override (재정의)
3) Upcasting
4) 동적 바인딩 (컴파일시랑 실행시 메소드 다름)


```java
public class PolyTest {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
        
        Animal animal1 = new Cat();
        animal1.eat();
    }
}
```
- 다형성은 UpCasting으로 객체를 생성한다
- 상속관계, 재정의, 동적 바인딩을 사용한다
- 상위클래스가 동일한 메시지로 하위클래스를 서로 다르게 동작시키는 객체지향 원리


### 다형성 활용(다형성 인수)
오버로딩 : 정적바인딩 = 컴파일 시점에서 사용될 메소드가 결정되는 바인딩
- 프로그램의 실행 속도와는 무관하다

오버라이딩 : 동적바인딩 = 실행시점에서 사용될 메소드가 결정되는 바인딩
- 프로그램의 실행 속도와 관계가 있다 ( -> 메모리를 찾아가야 하기 때문)

오버로딩은 좋지만, 인수가 다른 것이 많다면 여러개의 메소드를 생성해야 할 것 이다.

이럴 때는 상속관계에서 부모를 활용해서 메소드를 정의하면 좋다.



### 다형성 활용(다형성 배열)
```java
public class PolyMethodTest {
    public static void main(String[] args) {
        Dog d = new Dog();

        Cat c = new Cat();

        Animal[] animals = new Animal[2];
        animals[0] = d;
        animals[1] = c;
        display(animals);
    }

    private static void display(Animal[] animal) {
        for (int i = 0; i <animal.length ; i++) {
            animal[i].eat();
            if( animal[i] instanceof Cat) {
                ((Cat) animal[i]).nightEyeShine();
            }
        }
    }
```


다형성을 보장한다는 의미는 무엇인가요?
-> 부모가 명령을 내리면 자식이 반드시 동작(반응)을 해야 한다.
-> Override를 하지 않으면 디형성이 보장되지 않는다
```java

```


### abstract

abstract 클래스는 객체를 사용할 수 없다<br>
즉 재정의를 할 수 없다.