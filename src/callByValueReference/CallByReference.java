/*
	Call by reference는 메서드 호출 시 사용되는 인자 값의 
	메모리에 저장되어있는 주소(Address)를 복사하여 보낸다.
	
	그렇기 때문에 원본값은 변경
	
	출처 - https://re-build.tistory.com/3
 */

package callByValueReference;

public class CallByReference {
	int value;
	
	CallByReference(int value){
		this.value = value;
	}
	
	public static void swap(CallByReference x, CallByReference y) {
		int temp = x.value;
		x.value = y.value;
		y.value = temp;
	}
	
	public static void main(String[] args) {
		CallByReference a = new CallByReference(10);
		CallByReference b = new CallByReference(20);

		System.out.println("swap() 호출 전 : a = " + a.value + ", b = " + b.value);

		swap(a, b);

		System.out.println("swap() 호출 전 : a = " + a.value + ", b = " + b.value);
	}
}
