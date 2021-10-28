토비의 스프링: 스프링의 이해와 원리
===========================

## 목차
1. [오브젝트와 의존관계](https://ripple-acorn-981.notion.site/Part-1-1-88d993e0d0a24d95aed163bb010633d2)
2. [테스트](https://ripple-acorn-981.notion.site/part-1-2-b4ee905c8ec748f280abfa051713cbb6)
3. [템플릿](https://ripple-acorn-981.notion.site/part-1-3-93a0e2f01e634c9e9eaffc894c77a2ac)
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
    implementation 'net.sourceforge.javydreamercsw:H2-Driver:0.1'

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