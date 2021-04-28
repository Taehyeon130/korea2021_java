/*이 클래스는 현실의 사물을 표현하고지 하는 것이 아니라 메인을 두기 위한 실행용 클래스*/

class UseDog{
	public static void main(String[] args){
		//강아지 2마리를 메모리에 띄우기
		//띄울려면 메모리에 올려야하고 메모리에 올리기위해서는 실행을 해야한다
		//또한 거푸집에 불과한 강아지의 인스턴스를 생성해야한다
		//String name = new Dog().getName();
		//System.out.println(name);

		//강아지 1마리를 메모리에 올리고 그 강아지의 나이를 3세로 바꾼 후 변경된 나이를 출력해보시오
		//자바스크립트였다면? var d1 = new Dog();

		//자바와 같은 객체지향 언어에서는 개발자가 자료형을 정의할 수있다.
		//이 정의는 클래스라는 단위로 작성
		//개발자가 정의한 자료형 = 사용자 정의자료형. 따라서 개발자가 Dog이라는 클래스를 정의했다면 그것은 Dog형을 새롭게 탄생시킨것
		//이 시점 부터는 oop언어에서 자료형이 총 4개라고 할 수있다.

		Dog d2 = new Dog();
		System.out.println("강아지의 변경전 나이는"+d2.getAge());
		d2.age = 3; //d2라는 개가 보유한 age속성값을 3으로 변경
		System.out.println("강아지의 변경된 나이는"+d2.getAge());

		//강아지의 이름을 뽀미로 변경 후 출력
		d2.name="뽀미";
		System.out.println("강아지의 변경된 이름은 "+d2.getName());
	}
}