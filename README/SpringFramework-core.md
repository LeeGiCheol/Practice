## 스프링 프레임워크 핵심 기술

##### [인프런 스프링프레임워크 핵심 기술](https://www.inflearn.com/course/spring-framework_core)


- Spring이란?
    - 2003년에 등장한 Framework이다.  
    - Java EE와(EnterPrise Edition) 경쟁관계보단 호환관계라고 할 수 있다.  
    - "소규모 애플리케이션, 또는 기업용 애플리케이션을 자바로 개발하는데 있어 유용하고 편리한 기능을 제공하는 프레임워크" 이다.  


- IoC 컨테이너 
    - IoC(Inversion Of Control) - 제어의 역전
        - 어떤 객체가 사용하는 의존 객체를 직접 만들어 사용하는 것이 아니라, 주입받아 사용하는 방법  
        - 객체의 생명주기 관리를 개발자가 아닌 IoC 컨테이너가 대신 해주는 것  


- Bean
    - Bean?
        - IoC 컨테이너가 관리하는 객체
    - Bean Scope
        - SingleTone : 객체가 하나 (Bean 등록 시 기본 설정값이다.)
        - Prototype  : 매번 다른 객체
        - ...
    - ProtoType Bean은 SingleTone Bean 참조 가능
    - SingleTone Bean은 ProtoType Bean 참조 불가능
        - 이 경우 Bean이 업데이트가 안된다.
            - 해결 방법
                - Scoped-Proxy
                - Object-Provider
                - Provider(표준)
    - SingleTone 객체 주의사항
        - 프로퍼티가 공유된다. (변화될 가능성이 있다.)
        - ApplicationContext 초기 구동 시 인스턴스가 생성된다. (즉 실행이 느리다.)


- Autowired
    - 필요한 의존 객체의 "타입"에 해당하는 빈을 찾아 주입한다.
    - required : 기본값은 true이다. 따라서 빈을 못찾으면 구동 실패한다.

- 같은 타입의 빈이 여러개일때 (웬만하면 @Primary를 사용하는 것이 좋다.)
        - @Primary
        - List를 사용해 해당 타입의 빈을 모두 주입받기
        - @Qualifier (빈 이름으로 주입받기)


- @ComponentScan
    - Scan 위치 설정을 한다.
    - filter  (어떤 Annotation을 스캔할지 하지 않을지 결정)
        - excludeFilters
        - includeFilters
    - 실제 Scanning은 ConfigurationClassPostProcessor 라는 BeanFactoryPostProcessor 에 의해 처리된다.

- @Component
    - @Repository
    - @Service
    - @Controller
    - @Configuration


- Environment 
    - Profile과 Property를 다루는 Interface
    - 생성, 주요 메서드
        - ApplicationContext extends EnvironmentCapable
        - getEnvironment;
    - Profile
        - Profile?
            - Bean들의 그룹
            - Environment의 역할은 활성화할 프로퍼티 확인 및 설정
        - Profile UseCase
            - 테스트 환경에서는 A라는 Bean을 사용하고, 배포환경에서는 B라는 Bean을 쓰고싶다.
            - 이 Bean은 모니터링 용도니까 테스트할 땐 필요없고, 배포할때만 등록되면 좋겠다.
        - Profile 정의
            - 클래스에 정의
                - @Configuration @Profile("test")
                - @Component @Profile("test")
            - 메서드에 정의
                - @Bean @Profile("test")
        - Profile 설정
            - -Dspring.profiles.active="test"
            - @ActiveProfiles (테스트용)
        - Profile 표현식
            - ! (Not)
            - & (And)
            - | (Or)
    - Property
        - Property?
            - 다양한 방법으로 정의할 수 있는 설정 값
            - Environment의 역할은 프로퍼티 소스 설정 및 프로퍼티 값 가져오기
        - Property에는 우선 순위가 있다.
            - StandardServletEnvironment의 우선순위
                - ServletConfig 매개변수
                - ServletContext 매개변수
                - JNDI (java:comp/env)
                - JVM System Property (-D key = "value")
                - JVM System Environment Variable (운영체제 환경변수)
        - @PropertySource
            - Environment를 통해 프로퍼티 추가하는 방법
        - SpringBoot 외부설정
            - 기본 프로퍼티 소스 제공 (application.properties)
            - 프로파일까지 고려한 계층형 프로퍼티 우선 순위 제공


- MessageSource
    - 국제화 (i18n) 기능을 제공
    - 생성, 주요 메서드
        - ApplicationContext extends MessageSource
        - getMessage(String code, Object[] args, String, default, Locale, Ioc) ...
    - SpringBoot를 사용한다면 별다른 설정없이 MessageProperties 사용할 수 있다.
        - message.properties
        - message_ko_KR.properties


- ApplicationEventPublisher
    - 이벤트 프로그래밍에 필요한 인터페이스 제공. (옵저버 패턴 구현체)
    - 생성, 주요 메서드
        - ApplicationContext extends ApplicationEventPublisher
        - publishEvent(ApplicationEvent event)
    - 이벤트 만들기
        - ApplicationEvent 상속
        - Spring 4.2 부터는 이 클래스를 상속받지 않아도 이벤트로 사용할 수 있다.
    - 이벤트 발생시키는 방법
        - ApplicationEventPublisher.publishEvnet();
    - 이벤트 처리하는 방법
        - ApplicationListener<이벤트> 구현한 클래스 만들어서 빈으로 등록하기
        - Spring 4.2 부터는 @EventListener를 사용해서 빈의 메서드에 사용할 수 있다.    
        - 기본적으로 Synchronized
        - 순서를 정하고 싶으면 @Order
        - 비동기적으로 실행하고 싶으면 @Async
    - Spring이 제공하는 기본 이벤트
        - ContextRefreshedEvent : ApplicationContext를 초기화했거나, 리프레쉬 했을 때 발생
        - ContextStartedEvent   : ApplicationContext를 start() 하여 라이프 사이클 빈들이 시작 신호를 받을 시점에 발생
        - ContextStoppedEvent   : ApplicationContext를 stop() 하여 라이프 사이클 빈들이 정지 신호를 받을 시점에 발생
        - ContextClosedEvent    : ApplicationContext를 close() 하여 싱글톤 빈 소멸되는 시점에 발생
        - RequestHandledEvent   : HTTP 요청을 처리했을 때 발생


- ResourceLoader
    - 리소스를 읽어오는 기능을 제공하는 인터페이스
    - 생성
        - ApplicationContext extends ResourceLoader
    - 리소스 읽어오기
        - 파일 시스템에서 읽어오기
        - 클래스패스에서 읽어오기
        - URL로 읽어오기
        - 상대 / 절대 경로로 읽어오기
        

- Resource 추상화
    - 무엇인가
        - java.net.URL을 추상화 한 것
        - 스프링 내부에서 많이 사용하는 인터페이스
    - 추상화 한 이유
        - 클래스패스 기준으로 리소스 읽어오는 기능 부재
        - ServletContext를 기준으로 상대 경로로 읽어오는 기능 부재
        - 새로운 핸들러를 등록하여 특별한 URL 접미사를 만들어 사용할 수는 있지만, 구현이 복잡하고 편의성 메서드가 부족하다.
    - 주요 메서드
        - getInputStream()
        - exitst()
        - isOpen()
        - getDiscription
    - 구현체
        - URLResouce                : java.net.URL 참고. 기본으로 지원하는 프로토콜 (Http, Https, Ftp, File, Jar)
        - ClassPathResource         : 지원하는 접두어 classpath
        - FileSystemResource        :
        - ServletContextResource    : 웹 애플리케이션 루트에서 상대 경로로 리소스를 찾는다.
    - 리소스 읽어오기
        - Resource의 타입은 Location 문자열과 ApplicationContext의 타입에 따라 결정된다.
            - ClassPathXmlApplicationContext -> ClassPathResource
            - FileSystemXmlApplicationContext -> FileSystemResource
            - WebApplicationContext -> ServletContextResource
        - ApplicationContext의 타입에 상관없이 리소스 타입을 강제하려면 java.net.URL 접두어 (classpath:) 중 하나를 사용할 수 있다.
            - classpath:me/gicheol/config.xml -> ClassPathResource
            - file:///some/resource/path/config.xml -> FileSystemResource
    
- Validation 추상화
    - 무엇인가
        - 애플리케이션에서 사용하는 객체 검증용 인터페이스
    - 특징    
        - 어떠한 계층과도 관계가 없다. -> 모든 계층 (웹, 서비스, 데이터) 에서 사용해도 좋다.
        - 구현체 중 하나로 JSR-303 (Bean Validation 1.0) 과 JSR-349 (Bean Validation 1.1) 을 지원한다. (LocalValidatorFactoryBean)
        - DataBinder에 들어가 바인딩 할때 같이 사용되기도 한다.
    - 인터페이스
        - boolean supports(Class clazz) : 어떤 타입의 객체를 검증할 때 사용할 것인지 결정함
        - void validate(Object obj, Errors e) : 실제 검증 로직을 이 안에서 구현
            - 구현할 때 ValidationUtils 사용하면 편리함
    - 스프링부트 2.0.5 이상 버전을 사용할 때
        - LocalValidatorFactoryBean 빈으로 자동 등록 
        - JSR-380 (Bean Validation 2.0.1) 구현체로 hibernate-validator 사용


- DataBinding 추상화
    - DataBinding?
        - 기술적인 관점 : 프로펕티 값을 타겟 객체에 설정하는 기능
        - 사용자 관점 : 사용자 입력값을 애플리케이션 도메인 모델에 동적으로 변환해 넣어주는 기능
        - 해석하자면 : 입력값은 대부분 "문자열"인데 그 값을 객체가 가지고 있는 int, long, boolean, Date등 심지어 Event,Book 같은 도메인 타입으로도 변환해서 넣어주는 기능
    - PropertyEditor
        - 스프링 3.0 이전까지 DataBinder가 변환작업 사용하던 인터페이스
        - Thread-Safe하지 않음 (상태 정보 저장하고 있음. 따라서 싱글톤 빈으로 등록해 사용하면 안된다. BeanScope 중 Thread로 등록하면 사용 가능하지만 아에 등록은 않하는게 낫다.)
    - Obejct와 String 간의 변환만 할 수 있어, 사용범위가 제한적임 (그래도 그런 경우가 대부분이기 때문에 조심해서 잘 사용해 왔었음)
