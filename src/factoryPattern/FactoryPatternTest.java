// 팩토리패턴은 객체 생성을 담당 및 처리하는 클래스이다.

package factoryPattern;

public class FactoryPatternTest {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		shape2.draw();
		Shape shape3 = shapeFactory.getShape("SQUARE");
		shape3.draw();
	}
}
