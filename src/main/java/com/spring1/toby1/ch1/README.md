1. 오브젝트와 의존관계
================

### 스프링을 공부하면서 찾아가는 물음에 대한 답
>- 코드의 문제점은 무엇인가?
>- 개선해야 하는 이유는?
>- 개선 했을때의 장점은?
>- 개선 했을때의 현재,미래 유익함은?
>- 객체지향 설계의 원칙과는 무슨상관?
#DAO
##UserDao1 - 초난감 
>변화에 대한 대비 부재\
>관심사항 많음\
>~~분리와 확장 고려~~\
>~~관심사의 분리~~


- UserDao1 의 관심사항
1. DB 연결 connection 생성
2. DB에 보낼 SQL 생성&실행
3. 공유 리소스 반환

책임1이 method 마다 중복됨 -> **`method 추출`**

- 한 가지 관심에 대한 변경이 일어날 경우 그 관심이 집중된 부분만 수정
- 중복 제거

##UserDao2 - abstract class UserDao
- _Super class_ : DAO의 핵심기능 구현, 일부는 추상 method
- _Sub class_ : Super method 의 일부 기능 구현

`Template method pattern`
`Factory method pattern`
> 1. 다중 상속 불가능
> 2. 여저힌 두 가지 다른 관심사에 대한 긴밀한 결합 존재
> 3. 확장된 기능을 다른 Class 에 상속 불가능, 중복 야기
 


##UserDao3 - 별도의 class 분리
>- DB connection 확장 불가능
>1. SimpleConnectionMaker 에 Dao가 의존
>2. method가 뭔지 알고있음
 


##UserDao4 - interface 도입
>구현 Object 선택 결정이 UserDao 안에 있어(또 다른 책임)


##UserDao4 - DI
>- userDao 사용하는 client 가 구현 Object 결정  
>~~class->class~~\
> obj -> obj
>- **다형성**
***