package modifier;

public class ModiTest{
	/*수식자(modifier)에는 static말고도 여러가지가 있다
		개발자가 알아야할 수식자는 아래의 3가지
		1. static - 정적변수, 메서드,클래스 선언시 사용
		2. final - 변수,메서드, 클래스의 값을 고정할때 사용
					변수 : 상수처럼 고정
					메서드 : 오버라이딩을 허용하지 않음 즉 부모 메서드를 업그레이드 할 수없음
					클래스 : 더 이상 자식을 두지 않음 따라서 외부의 클래스가 해당 클래스 상속할 수 없음/대가 끊김
		3. abstract - 추상클래스, 메서드  선언 시 사용
	*/

	public static void main(String[] args){
		final int x = 3; //더 이상 변수 x의 값은 이 시점 이후부터는 변경이 불가!!
		x = 9;
	}
}