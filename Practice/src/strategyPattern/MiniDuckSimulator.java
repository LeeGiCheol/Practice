/*
	기능을 정의하고 각각의 캡슐화하여 교환해 사용할 수 있도록 함.
	알고리즘을 사용하는 클라이언트와 독립적으로 알고리즘을 변경할 수 있음
	(기능을 바꾸거나 추가하되 기능 이외에 영향은 미치지 않는다.)
 */

package strategyPattern;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		
		mallard.setFlyBehavior(new FlyNoWay());
		mallard.performFly();
	}
}
