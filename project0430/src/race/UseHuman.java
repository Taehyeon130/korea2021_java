package race;

class UseHuman{
	public static void main(String[] agrs){
		Black b = new Black();
		//b.IQ=110; //단지 Black이라는 클래스에 존재하지 않을뿐 이미 부모클래스에 존재함
		
		//상속관계에서 주의할 점!! 부모의 코드가 자식 클래스에 붙여넣기 되는게 아니라 
		//단지 서로 다른 인스턴스 영역을 가진 상태에서 자식의 인스턴스가 부모의 인스턴스 영역을 마치 자기것 처럼 접근, 즉 영역을 확장하는 것 뿐
		//따라서 부모와 자식은 자신만의 변수를 가질 수 있고 이때 변수명이 동일 할 수도 있다.

		b.speak();
		b.drive();
	}
}