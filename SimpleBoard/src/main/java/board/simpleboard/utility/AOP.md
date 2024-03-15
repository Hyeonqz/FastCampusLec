## Spring AOP

관점지향 프로그래밍 이라는 뜻

스프링 어플리케이션은 대부분 특별한 경우를 제외 하고는<br>
MVC 웹 어플레케이션에서는 Web Layer, Business Layer, Data Layer 로 정의한다.

- Web Layer : REST API 를 제공하며, Client 중심의 로직 적용한다.
- Business Layer : 내부 정책에 따른 Logic 을 개발하며, 주로 해당 부분을 개발
- Data Layer : 데이터 베이스 및 외부와의 연동을 처리한다.

```java
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;

@Aspect
// 자바에서 사용하는 AOP 프레임워크에 퓨함되며, AOP 를 정의하는 Class 에 할당

@PointCut
// 기능을 어디에 적용시킬지, 메소드? Annotation? AOP를 적용 시킬 지점을 설정한다.

@Before
// 매소드 실행하기 전 시점에 콜백을 받는다.

@After
// 메소드가 성공적으로 실행 후, 예외가 발생 되더라도 콜백을 준다

@AfterReturning
// 메소드가 성공으로 실행했을 때만 콜백이 온다

@AfterThrowing
// 메소드 호출 실패 예외 발생시 사용

@Around
// Before, After 모두 제어한다
```