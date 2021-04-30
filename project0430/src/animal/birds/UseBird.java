package animal.birds;

/*
	상속에서 놓치지 말아야할 핵심 주제
	1) 코드의 재사용
	2) 객체간 형변환(짱 중요)
*/
class UseBird{
	public static void main(String[] args){
		//[기본자료형 형변환 예]
		int x=7; //4byte 큰 자료형
		byte b=3; //1byte 작은 자료형
		//x=b; //가능 
		b=(byte)x; //불가능 손실이 발생함 하지만 개발자가 손실을 감안해서라도 형변환을 명시하면 인정해줌 = 강제형변환 / (소괄호) = 캐스트연산자

		//[객체자료형 형변환 예]
		Bird bird = new Bird("green");
		Duck d = new Duck("yellow"); //인스턴스 총 3개 
		bird=d; //기본자료형에 비추어 용량의 문제로 접근하면 안됨
		// 객체간 형변환은 누가 더 폭넓은 객체를 가리킬 수 있는가? 상위자료형

		bird.fly();
		//bird.canSwim(); //불가능
		//bird변수의 자료형은 Bird이기 때문에 당연히 Bird클래스에는 canSwim()메서드가 없다

		Duck duck =(Duck)bird; //객체간의 형변환도 가능하다,,, 이때 자식 자료형으로의 형변환을 가리켜 downCasting이라 한다....
		
		duck.canSwim();

	}
}