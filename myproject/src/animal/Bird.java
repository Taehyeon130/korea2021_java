package animal; //컴파일시 이 Bird의 .class를 animal이란 패키지를 자동 생성하여 넣어준다...   javac -d옵션에 의해서 

//패키지에 넣어둔 클래스는 아무도 접근 못하므로 공개해야한다.
//공개를 결정짓는 키워드인 public(접근제어자)

public class Bird{ //패키지 선언시 무조건 public 
	String name="앵무새";
	public void fly(){
		System.out.println(name+"가 날아감");
	}
}