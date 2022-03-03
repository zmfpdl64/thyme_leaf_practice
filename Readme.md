<h2>기본 서식</h2>

    1. *    //object의 속성값을 나타낼 수 있다.
    2. #    //다국어 설정을 해 사용한다.(번역)
    3. $    //변수를 사용할 때 사용한다.
    4. ~    //템플릿을 교체, 삽입 할때 사용한다.
    5. @    //url링크에 변수를 이용할 때 사용한다.

1. href="www.naver.com"

2. th:href="@{/css/gtvg.css}"

front로 구동하면 1번이 back으로 구동하면 2번이 실행된다.

text 텍스트만 출력이 가능하다.

utext 태그까지 출력이 가능하다

<h2>스탠다드 출력</h2>

표현식 기본 개체 컨텍스트 변수에 대한 OGNL 식을 평가할 때, 일부 개체는 보다 높은 유연성을 위해 식에 사용할 수 있도록 한다.이러한 객체는 (OGNL 표준에 따라) 에서 시작하여#기호:

    ctx: 컨텍스트 객체.
    vars:문맥 변수
    locale: 컨텍스트 로케일.
    request: (웹 컨텍스트에서만)HttpServletRequest이의를 제기하다
    response: (웹 컨텍스트에서만)HttpServletResponse이의를 제기하다
    session: (웹 컨텍스트에서만)HttpSession이의를 제기하다
    servletContext: (웹 컨텍스트에서만)ServletContext이의를 제기하다

예시

    Established locale country: <span th:text="${#locale.country}">US</span>.

<h1>ORM 기술</h1>

marven mariadb 여기서 implements 코드 가져온다.

marven jpa 여기서도 implements 코드 가져온다.

mariadb spring boot 를 검색해서 properties 설정을 한다.

    spring.datasource.driverClassName=org.mariadb.jdbc.Driver
    spring.datasource.url=jdbc:mariadb://127.0.0.1:3307/mydb
    spring.datasource.username=woojin
    spring.datasource.password=1234
    #spring.jpa.hibernate.ddl-auto=create-drop  실행될때마다 테이블이 생성되고 종료되면 테이블이 삭제된다.

