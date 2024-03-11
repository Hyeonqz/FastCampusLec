## 자바 최상위 객체 Object 이해하기

```java
public class ObjectEx {
    
}

```
위 코드를 생성을 하면은 기본적으로 생략된 것이 3개가 있다<br>
그 3개가 무엇일까요?
```java
1) import java.lang.*

2) public class -> extends Object

3) public ObjectEx() {
    super();
}
```
위 3가지가 생략이 되어있다<br>
자바에서 자동으로 생략을 해주는 것 입니다.<br>
컴파일러에서 자동으로 넣은 상태로 실행을 시켜주는 것입니다<br>
묵시적으로 위 코드들은 무조건 들어가 있어야 합니다<br>
위 3가지는 항상 들어가야하는 default 값 이라고 생각하면 됩니다

Object는 java.lang에 들어가있는 객체 중 하나이고 그것을 자동으로 import가 됩니다

그리고 객체를 생성할 때, 상위 클래스를 받아온다

즉
1) default package
2) java.lang.Object (최상위 클래스)
3) default 생성자

위 3가지는 클래스를 생성하는 순간 이미 들어가있다고 보면 됩니다.

```java
import java.lang.*;

public class ObjectEx extends Object{
    public ObjectEx() {
        super();
    }
}

```
전체적으로 보면 클래스를 생성시 사실은 위 구조가 기본 클래스의 구조 입니다.

객체를 직접 생성을 해봅시다.
```java
public class ObjectTest {
    public static void main(String[] args) {
        // ObjectEx 객체를 upCasting 으로 생성 -> 객체를 부모 타입으로 만드는 것
        var objectEx = new ObjectEx();
        objectEx.display();
        
        Object object = new ObjectEx();
        object.display(); 
        // 안됌 -> Object 객체는 자바에서 만들어 둔거기 때문에 그 클래스에는 내가 만들어둔 display가 없다


    }
}
```

만약에 Object 클래스로 객체를 생성하고, 내가 만들어둔 메소드를 만들기 위해서는 <br>
다운캐스팅을 이용해야 한다.
```java

Object object = new ObjectEx();
        
((ObjectEx)object.display()); 
```
위 과정처럼 다운 캐스팅을 해야지, 객체가 내가 만들어둔 객체로 인식을 하여<br>
원하는 메소드를 사용할 수 있습니다.


이번에는 다형성 인수로 Object 객체를 활용해보겠습니다.
```java
public class ObjectA {
    public void printGo(Object o) {
        System.out.println("나는 객체 A 이다");
    }
}

```

```java
public class ObjectB {
    public void printGo(Object o) {
        System.out.println("나는 객체 B 이다");
    }
}

```

```java
package Object;

public class ObjectPolyTest {
    public static void main(String[] args) {

        var a = new ObjectA();
        printGo(a);
        var b = new ObjectB();
        printGo(b);
    }

    private static void printGo(Object obj) {
        if (obj instanceof ObjectA) {
           ((ObjectA) obj).printGo(obj);
        } else {
            ((ObjectB)obj).printGo(obj);
        }
    }
}

```

다형성을 간단하게 적용해본 예시 입니다. 

### Object 클래스의 toString() 메소드를 알아보자
toString 은 객체의 번지를 문자열로 출력하기 위한 메소드 입니다.

말로는 이해하는 것보다 코드로 보면 이해가 편합니다
```java

class BoardEx extends Object{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

public class ObjectToString {
    public static void main(String[] args) {
        var b = new Board();
        b.setTitle("나의 게시글 입니다.");
        System.out.println(b.getTitle());
        System.out.println(b);
        System.out.println(b.toString());
    }
}
```
위 코드에 결과는 무엇일까요?
> 내 게시글 입니다.<br>
> Object.BoardEx@5acf9800 <br>
> Object.BoardEx@5acf9800

이런 결과가 나옵니다.

그럼 여기서 나오는 뭔가 저 이상한 글자들은 무엇일까요?

저것들은 바로 객체의 주소(=메모리 주소) 를 의미합니다.<br>
toString 은 원래 문자열 값을 가져오는거데, 객체 자체의 값은 숫자로 이루어져 있으니<br>
숫자를 문자들로 바꿔서 16진수의 값으로 객체의 주소를 가져오는 것 입니다.<br>

하지만 나는 저 메모리의 주소가 아닌, 평소에 쓰던 toString 처럼 진짜 값을 가져오고 싶다면?<br>

바로 재정의를 통해서 내가 커스텀을 할 수 있습니다.
```java
    @Override
    public String toString() {
        return "BoardEx{" +
                "title='" + title + '\'' +
                '}';
    }
```

- mac 기준으로 cmd + n 버튼을 눌러서 간단하게 재정의를 할 수 있습니다.
- 재정의를 하고 다시 결과값을 보면은
> 내 게시글 입니다.<br>
BoardEx{title='내 게시글 입니다.'}<br>
BoardEx{title='내 게시글 입니다.'}

위 처럼 결과값을 가지게 됩니다. 

신기하지 않나요? 

16진수의 숫자 값이 아닌, 내가 원하는 값으로 커스텀이 되었습니다.

여기서 한번 부모의 값도 보고싶고, 내가 원하는 값도 보고싶다면
```java
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "BoardEx{" +
                "title='" + title + '\'' +
                '}';
    }
```
toString에 super메소드를 넣어서 부모의 값도 얻어오면 <br>
처음에 봤던, 메모리 주소랑 내가 원하는 값 둘다 얻어올 수 있습니다.

이상입니다.












