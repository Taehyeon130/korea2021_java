/*현실의 강아지를 정의해보자*/
class Dog{
		/*
		강아지가 가질 수 있는 속성들을 변수로 선언
		하나의 클래스가 보유한 변수들은 현실의 객체를 반영한 상태, 속성을 표현했다고 하여
		>> property(속성)라 한다
		*/
		int age = 5;
		String color="white"; //js와 같이 문자열을 객체로 처리함
		String name = "Luca";

		//함수 즉 메서드 정의...js와 약간틀림(전체적인 틀은 같다)
		//publid 접근제한자 . void 이 메서드가 반환값이 없다 (=반환값이 없는 함수)
		public String getName(){
			return name;
		}
		public int getAge(){
			return age;
		}
		public void run(){
			System.out.println(name+"가 뛰어요");	
		}
	
}

