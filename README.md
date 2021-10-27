토비의 스프링: 스프링의 이해와 원리
===========================

## 목차
1. 오브젝트와 의존관계
2. 테스트
3. 템플릿
4. 예외
5. 서비스 추상화
6. AOP
7. 스프링 핵심기술의 응용
8. 스프링이란 무엇인가?
9. 스프링 프로젝트 시작하기

## 환경

<pre>
<code>
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-jdbc'
    implementation 'org.springframework.boot:spring-boot-starter-web'

    compileOnly 'org.projectlombok:lombok'
    runtimeOnly 'com.h2database:h2'

    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
</code>
</pre>

- IntelliJIDEA
- gradle 프로젝트
- H2 database
- lombok
- assertJ
- spring boot