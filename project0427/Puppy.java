/*강아지*/
class Puppy{
	int age =5;
	boolean hasGuard; //멤버변수를 개발자가 초기화하지 않으면, 이 클래스로부터 메모리에 올라가는 인스턴스의 변수값에 디폴트 값이 적용됨
								// 컴파일러에 의해서 초기화된다. 
								// 논리값=false 정수=0
								//단, 이 원칙은 멤버변수에만 적용된다. (객체의 속성에 대해서만 적용된다)

	public void setAge(){
		age=3;
		//int k; //k값은 자동초기화 되지 않는다 > 멤버변수가 아니라서

	}

	public static void main(String[] agrs){
		//강아지의 나이를 3세로 변경한 후 나이 출력하기
		
		Puppy p = new Puppy(); //강아지 1마리의 인스턴스 생성
		//즉 위의 과제를 수행하려면 생물학적으로 강아지가 태어나야 가능하다

		p.setAge();
		System.out.println(p.age);
	}
}