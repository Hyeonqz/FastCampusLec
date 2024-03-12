## 스프링 예외처리
#### 간단한 스프링 동작과정
1) 요청이 온다
2) filter를 거친다
3) dispatcherServlet에서 핸들러 매핑을 통해서 어떠한 주소를 가진 컨트롤러에 매핑을 해야하는지 결정한다
4) 핸들러 인터셉터를 통과한다.
5) 작성한 컨트롤러가 요청이 들어오고
6) 서비스,DB를 통한 데이터를 처리하고 응답을 내려준다
7) 그리고 핸들러 인터셉터를 다시 통과하고
8) dispatcherServlet를 거쳐
9) filter를 통과하고
10) 응답을 내려준다

근데 이 과정에서 예외가 발생하게 되면은 ExceptionHandler가 동작해서 응답을 내려준다.

예외가 발생을 해도 비정상적인 응답을 내려줍니다<br>
우리는 advice를 통해서 예외를 처리해야 합니다.