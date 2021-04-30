package race;

//인류의 보편적 특징을 모두 물려받은 흑인을 정의
//이 클래스에서는 흑인이 가진 특징만 보유하면 됨
public class Black extends Human{
	/*
		이 코드는 우리가 절대 볼 수없다
	    왜? 개발자가 생성자를 정의하지 않을 경우에 내부적으로 컴파일러에 의해 처리되므로
		public Black(){
			super(); //부모생성자 호출하는 코드가 자동으로 
		}
		//부모한테 매개변수가 있으면 디폴트 생성자로는 오류가 발생함
	*/

	//부모의 생성자에 매개변수가 존재하므로 더이상 현재 클래스의 디폴트 생성자에 의존하다가는 에러가 발생함
	//따라서 개발자가 나서서 부모의 인수가 있는 생성자를 직접 호출해야한다.

	public Black(){
		//System.out.println("흑인 초기화"); //부모가 먼처 초기화되어야 하므로 super보다 앞선 코드는 존재해서는 안됨
		super(200); //IQ의 값을 넘겨줌
		System.out.println("흑인 초기화");
	}
	

	String color = "black";
	int IQ=110; //부모에 있지만 덮어쓰지도 않음

	public void run(){
		System.out.println("육상을 잘한다");
	}
}