package vehicle;
	//엔진 보유
	//Car has a Engine
	/*
		특정 클래스가 다른 클래스를 멤버변수로 보유한 경우 이를 가르켜 has a 관계라 한다
		참고로 자바와 같은 OOP언어에서는 객체들간 관계는 크게 2가지
		1) is a : 상속관계
		2) has a : 부품관계
		- oop기반으로 개발을 하다보면, 여러 클래스로 개발을 하게되며 이 클래스들간에는 관계를 형성할 수 있는데 
		   이때 이 관계를 is a, has a관계로 분류됨
	*/
public class Car{

	Engine e; //객체자료형은 최소한의 관여?  null로 초기화됨... null은 아무런 데이터가 들어있지 않다는 것
	Wheel w;
	int price; //default값 0
	String color; //String도 객체이므로, null로 초기화되어있음(개발자가 아무것도 초기화 안했을때,,,,)
	
	//부품관계를 선언했다면, 초기화는 더욱 더 절실하다!! 초기화를 담당하는 영역은 생성자이다!!
	//즉 생성자를 적극 활용할 필요가 있다..
	public Car(){
		//has a 관계에 명시한 변수들에 대한 필요한 모든 초기화를 시도!!
		e = new Engine();
		w = new Wheel();
		price=5000;
		color="red";
	}

}