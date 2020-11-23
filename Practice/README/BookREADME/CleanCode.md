클린코드  

2020 / 08 / 17 월   
96p ~ 137p  

-5장 형식 맞추기-  

 - 세로 행의 길이가 적당해야 한다. 
실제로 서비스중인 프로그램 중  
FitNesse 프로젝트의 평균 크기는 약 65줄이다.  
가장 긴 파일은 약 400줄이고 가장 짧은 파일은 6줄이다.  
반면 Tomcat이나 Ant는 절반 이상이 200줄이 넘어서고   
심지어 수천 줄이 넘는 파일도 많다.  
이것은 대부분 200줄 정도인 파일로도 커다란 시스템을 구축할 수 있다는 사실이다.  
(FitNesse는 총 50,000줄에 육박하는 프로그램이다.)  
반드시 지킬 필요는 없지만 일반적으로 큰 파일보단 작은 파일이 이해하기 쉽다.	
    -96p  

 
 - 빈 행은 새로운 개념을 시작한다는 시각적 단서이다.  
패키지 선언부, import문, 각 함수 사이에는 빈 행이 들어간다.  
일련의 행 묶음은 완결된 생각 하나를 표현한다.  
글을 쓸때 단락을 생각하면 될것같다.  
단락을 나누지 않으면 가독성이 무척 떨어질 것이다.  
	-98p  


 - 인스턴스 변수는 자바는 보통 클래스 맨 처음에 선언한다. 
(C++은 클래스 마지막에 선언하는 경우도 많다. 이를 가위규칙이라 한다)  
	- 101p  


 - 간단한 if문, 짧은 while문, 짧은 함수에서도 들여쓰기를 넣자.
ex) public String render() throws Exception {return “”; } 보다는  
public String render() throws Exception {  
	return “”;  
} 으로 사용하자.  
	-112p  


-6장 객체와 자료 구조-  

 - 자료구조를 사용하는 절차적인 코드는 기존 자료 구조를 변경하지 않으면서 새 함수를 추가하기 쉽다. 
반면, 객체 지향 코드는 기존 함수를 변경하지 않으면서 새 클래스를 추가하기 쉽다  
반대도 마찬가지이다.  
절차적인 코드는 새로운 자료 구조를 추가하기 어렵다. 그러려면 모든 함수를 고쳐야 한다.  
객체 지향 코드는 새로운 함수를 추가하기 어렵다. 그러려면 모든 클래스를 고쳐야 한다.  
	-122p  


 - 기차 충돌 코드를 피해라.
final String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();  
이러한 코드를 흔히 기차 충돌이라 부른다. 여러 객체가 한줄로 이어진 기차처럼 보이기 때문이다.  
일반적으로 조잡하다 여겨지는 방식이므로 피하는 편이 좋다.  
위 코드는 다음과 같이 나누는것이 좋다.  
Options opts = ctxt.getOptions();  
File scratchDir = opts.getScratchDir();  
final String outputDir = scratchDir.getAbsolutePath();  
	- 124p  


-7장 오류 처리-  

 - 오류 코드보다는 예외를 사용해라.
	-130p  
 


2020 / 08 / 23 일  
137p ~ 169p  

 - null을 반환, 전달하지마라
Collections.emptyList()를 사용해 미리 정의된 읽기 전용 리스트를 반환해라  
assert문을 사용해라  
	-139~141p  


-8장 경계-  

- 외부코드 (오픈소스)등을 사용할때  
예를들어 Map 객체는 누구나 지울 수 있고,  
설계 시 Map에 특정 객체 유형만 저장하기로 결정했다고 가정하더라도  
Map은 객체 유형을 제한하지 않기 때문에 마음만 먹으면 사용자는 어떤 객체 유형도 추가할 수 있다.  
ex)  
Map sensors = new HashMap();  
Sensor s = (Sensor)sensors.get(sensorId);  
이런 식으로 사용할 것이다.  

->  

Map<String, Sensor> sensors = new HashMap<Sensor>();  
Sensor s = sensors.get(sensorId);  
제네릭을 사용하면 가독성이 더 높아  진다.

하지만 Map<String, Sensor>가 사용자에게 필요하지 않은 기능까지 제공한다는 문제가 아직 남아있다.  

->  

public class Sensors {  
	private Map sensors = new HashMap();  

	public Sensor getByid(String id) {  
		return (Sensor) sensors.get(id)  
	}  
}  
Sensors 클래스에서 객체 유형을 관리하는 이런 방식으로 바꿔보자.  

항상 이렇게 만들라기보단 Map을 여기저기 넘기면 안된다.  
	-146p  

- log4j 익히기
	-147p  


- 9장 단위테스트 -

 - TDD 법칙 세가지
1. 실패하는 단위 테스트를 작성할 때까지 실제 코드를 작성하지 않는다.  
2. 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위테스트를 작성한다.  
3. 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다.  
	155p  
  
 - assert문은 테스트 당 하나
조건에 만족하기 어렵다면 테스트를 두개 이상으로 쪼개 각자 assert를 수행하면 된다.  
	164p  

 - 테스트 함수마다 한 개념만 테스트하라.
여러 개념을 한 함수에 몰아넣으면   
독자가 각 절이 거기에 존재하는 이유와   
각 절이 테스트하는 개념을 모두 이해해야한다.  

 - 깨끗한 코드는 다음 다섯가지 규칙을 따르는데 F.I.R.S.T 이다
F(Fast) 빠르게, 테스트는 빨리 돌아야 한다.  
	자주 돌리지 않으면 초반에 문제를 찾아내 고치지 못한다.  
I(Independent) 독립적으로, 각 테스트는 서로 의존하면 안 된다.  
	한 테스트가 다음 테스트가 실행될 환경을 준비해서는 안된다.  
	테스트가 서로에게 의존하면 하나가 실패할 때 나머지도 잇달아 실패하므로  
	원인을 진단하기 어려워지며 후반 테스트가 찾아내야 할 결함이 숨겨진다.  
R(Repeatable) 반복가능하게, 테스트는 어떤 환경에서도 반복 가능해야 한다.  
	실제 환경, QA 환경, 네트워크가 연결되지않은 환경에서도 실행할 수 있어야 한다.  
S(Self-Validating) 자가검증하는, 테스트는 bool 값으로 결과를 내야한다. 성공 아니면 실패이다.  
	통과 여부를 알려고 로그 파일을 읽게 만들어서는 안 된다.  
	테스트가 스스로 성공과 실패를 가늠하지 않는다면 판단은 주관적이 되며   
	지루한 수작업 평가가 필요하게 된다.  
T(Timely) 적시에, 테스트는 적시에 작성해야 한다.   
	단위 테스트는 테스트하려는 실제 코드를 구현하기 직전에 구현한다.  
	실제 코드를 구현한 다음에 테스트 코드를 만들면   
	실제 코드가 테스트하기 어렵다는 사실을 발견할지 모른다.  
	테스트가 불가능하도록 실제 코드를 설계할지도 모른다.  
		167~168p  



2020 / 09 / 20 월  
172p ~ 221p  

-10장 클래스-  

 - 클래스는 작아야한다.
클래스는 작아야한다. 더 작아야한다.  
그러면 얼마나 작아야하는가?  
함수는 물리적인 행 수로 크기를 측정했다.  
클래스는 다른 척도를 사용한다. 바로 클래스가 맡은 책임을 센다.  
메서드 5개 정도면 괜찮다.  
	173p  

 - 클래스 이름은 해당 클래스 책임을 기술해야 한다.
클래스 이름에 Processor, Manager, Super 등과 같이 모호한 단어가 있다면   
클래스에다 여러 책임을 떠안겼다는 증거다.  
이는 객체지향 설계원칙 중 (SOLID) SRP (단일 책임 원칙) 와 연관이 있다.  
클래스나 모듈을 변경할 이유가 단 하나뿐이여야 한다는 원칙이다.  
 또한 클래스의 설명은 만일 (if) , 그리고 (and) , -(하)며 (“or”) , 하지만 (but) 을   
사용하지 않고 25단어 내외로 가능해야한다.  
	175p    

 - 변경으로부터 격리
객체지향 프로그래밍 입문에서 구체적인 클래스와 추상 클래스가 있다고 배웠다.  
상세한 구현에 의존하는 클라이언트 클래스는 구현이 바뀌면 위험에 빠진다.  
그래서 인터페이스와 추상 클래스를 사용해 구현이 미치는 영향을 격리한다.  
 상세한 구현에 의존하는 코드는 테스트가 어렵다.  
시스템의 결합도를 낮추면 유연성과 재사용성도 더욱 높아진다.  
결합도가 낮아진다는 말은 각 시스템 요소가 다른 요소로부터  
그리고 변경으로부터 잘 격리가 되어 있다는 의미다.  
이렇게 결합도를 최소로 줄이면 자연스럽게 또 다른 클래스 설계 원칙인   
DIP (Dependency Inversion Principle) 을 따르는 클래스가 나온다.  
본질적으로 DIP는 클래스가 상세한 구현이 아니라 추상화에 의존해야 한다는 원칙이다.  
	189p  

-11장 시스템-  

-12장 창발성-  








