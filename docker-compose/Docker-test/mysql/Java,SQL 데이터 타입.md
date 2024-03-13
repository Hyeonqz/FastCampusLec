## Java 와 SQL 데이터 타입 비교

### 문자열
> CHAR -> String -> 고정 길이의 문자열 데이터 (안변함) <br><br>
> VARCHAR -> String -> 가변 길이의 문자열 데이터 (변함) <br><br>
> TINYTEXT -> String -> 문자열 데이터(255) <br><br>
> TEXT -> String -> 문자열 데이터 (65535) <br><br>
> JSON -> String -> JSON 문자열 데이터 <br><br>

여기서 가장 많이 사용하는 것은 VARCHAR 와 TEXT 두개를 많이 사용한다.

### 정수형
> SMALLINT -> Integer, int -> 정수형 ( 0 ~ 65536) <br><br>
> INT -> Integer, int -> 정수형 데이터<br><br>
> BIGINT -> Long, long -> 정수형 데이터 (무제한 수 표현)<br><br>
> DECIMAL -> BigDecimal -> 고정 소수형 데이터 (금액을 다룰 때 사용)<br><br>

primitiveType 은 기본값이 0이다 <br>
레퍼런스 타입은 null이 가능하다<br>
그러므르 자바에서 정의할때는 래퍼런스 타입을 정의해야 한다.

### 시간
> Date -> Date,LocalDate -> 날짜 (년,월,일) 형태 기간 데이터<br><br>
> Time -> Time,LocalTime -> 시간 (시,분,초,나노초) 형태 데이터<br><br>
> DateTIme -> DateTime,LocalDateTime -> 날짜 + 시간 데이터<br><br>
> TimeStamp -> DateTime, LocalDateTime -> 날짜와 시간 데이터, Time Zone 속성<br><br>
> YEAR -> Year -> 년도 표현 데이터 타입<br><br>

- 글로벌 시간을 본다면 TimeStamp 사용
- 나머지는 DateTime 이 무난하다고 함


### BYTE
> BINARY -> byte[] -> CHAR 형태의 이진 타입