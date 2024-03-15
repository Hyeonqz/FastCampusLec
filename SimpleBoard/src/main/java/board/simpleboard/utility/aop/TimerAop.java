package board.simpleboard.utility.aop;

import board.simpleboard.utility.model.UserRequest;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@Aspect // AOP 를 사용하기 위한 내용을 정의하겠다
@Component // 스프링으로 부터 관리 받는다
public class TimerAop {

    // 스프링에서 관리되고 있는 Bean 들에게만 스프링 AOP 가 적용이 된다.
    // 만약에 Bean 이 아닌 다른 클래스 지정하고 싶으면, AOP 가 아닌 aspectj 라이브러리를 사용해야 한다.
    @Pointcut(value = "within(board.simpleboard.utility.controller.UserController)")
    public void timerPointCut () {

    }

    @Before(value = "timerPointCut()")
    public void before (JoinPoint joinpoint) {
        System.out.println("before");

    }

    @After(value= "timerPointCut()")
    public void after (JoinPoint joinpoint) {
        System.out.println("after");
    }

    @AfterReturning(value = "timerPointCut()", returning = "result")
    public void afterReturning (JoinPoint joinPoint, Object result) {
        System.out.println("after returning");
    }

    // argument 이름이 어떠한 값이 오는지 지정을 해줘야 한다.

    @AfterThrowing(value = "timerPointCut()", throwing = "tx")
    public void afterThrowing (JoinPoint joinPoint, Throwable tx) {

    }

    @Around(value = "timerPointCut()")
    public void around (ProceedingJoinPoint joinPoint) throws Throwable { //포인트컷을 지정한 위치로 보면됨
        System.out.println("메소드 실행 이전이다");

        // 해당 메도스가 실행될 때 모든 매개변수를 불러온다
        Arrays.stream(joinPoint.getArgs()).forEach(
                it -> {
                   if (it instanceof UserRequest) {
                       var tempUser = (UserRequest)it;
                       var phoneNumber = tempUser.getPhoneNumber().replace("-","");

                       tempUser.setPhoneNumber(phoneNumber);

                   }
                }
        );

        // 암 복호화 로깅 할 때 사용
        var newObjs = Arrays.asList(
                new UserRequest()
        );

        var stopWatch = new StopWatch();
        stopWatch.start();

        joinPoint.proceed(newObjs.toArray()); // 메소드를 실행시킨다.

        stopWatch.stop();

        System.out.println("총 소요된 시간 : " + stopWatch.getTotalTimeMillis());

        System.out.println("메소드 실행 후 이다");
    }


}
