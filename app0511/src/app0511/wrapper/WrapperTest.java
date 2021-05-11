/*
 * 자바의 기본자료형마다 1:1대응되는 객체가 지원되는데 이러한 클래스를 가리켜 Wrapper클래스라 한다
 * */
package app0511.wrapper;

public class WrapperTest {
	public static void main(String[] args) {
		Integer it = new Integer(7);
		Integer it2=9; //가능함 it2가 레퍼련스 변수임에도 불구하고 가능함
		//내부적으로는 9라는 정수를 객체화 시켜준 것이다.. 이 현상을 Wrapping이라 하고, 이를 가리켜 sun에서는 Boxing이라한다(기본자료형이 객체자료형으로 형변환)
		
		int k = it2; //객체자료형이 기본자료형으로 자동으로 형변환되는 현상 = unBoxing
	}
}
