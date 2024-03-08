## POST
- 리소스 생성, 추가
- 멱등성 X 
- 데이터가 유동적으로 변하기 때문에 안정성은 적다
- PathVariable 은 가진다. 데이터 전달방식에 적합
- Query Parameter -> 데이터를 필터링할때 사용함. 그래서 적합하지 않다.
- Data body를 가지고 있다.

HTTP는<br>
HTTP Header<br>
HTTP Body<br>
이 두가지로 구성된다<br>
post에서는 문자로 이루어진 메시지를 url 담아서 보낸다.<br>
get방식은 url에 다 보이지만, post는 외부 주소에 데이터가 보이지 않는다.<br>
그러므로 get방식 보다는 안전하다. 

post방식은 파라미터값으로 받을때 객체를 받아야한다.


### slf4j

로그는 자체적으로 버퍼를 가지고 있기 때문에 system.out 보다 효율이 좋다<br>


스프링부트는 기본적으로 Jackson 라이브러리를 사용해서<br>
엔티티를 JSON으로 바꿔줍니다
#### Jackson 동작과정

ObjectMapper는 변수에 매칭되는게 아닌 get() 메소드에 매핑이 된다<br>
getName -> Name에 매핑이 된다

Json 값으로 사용하지 않겠다?<br>
**`@JsonIgnore`**







