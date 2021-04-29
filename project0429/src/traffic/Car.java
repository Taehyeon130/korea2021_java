package traffic;


//java에서는 같은 메서드 명을 사용할 수있다
//메서드명은 같지만 완전히 일치하게 정의하는 것이 아니라 매개변수의 자료형과 갯수를 틀리게 하면 중복정의로 간주하지 않음
//오버로딩(Overroading) - 메서드 중첩
//즉 개발자가 비슷한 로직으로 메서드를 정의할 경우 큰 차이가 없음에도 불구하고 메서드명을 전혀 다르게 줘야하는 불편함을 해소할 수 있다.

class Car{
	public void run(){ 
		System.out.println("자동차 붕붕붕");
	}

	public void run(int vel){
		System.out.println("자동차 쪼금 붕붕붕");
	}

	public void run(boolean flag){
		System.out.println("......");
	}

}