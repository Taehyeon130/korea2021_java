package animal.birds;


/*
아래 코드의 상속관계가 같은 종류가 될 수있다는 근거!!
1) 자바에서는 기본 자료형들의 유형은 크게 3가지 분류
	문자,숫자,논리값
	특히 숫자(byte,short,int,long,float,double)와 char(0포함 양수)들 간에는 서로 같은 종류의 자료형으로 보고 형변환이 가능하다
2) 자바의 자료형은 총 4가지로서, 객체자료형도 자료형이다

3) 결론 : 2번과 같이 객체자료형도 자료형이라면, 기본 자료형들간에 적용되었던 객체간 형변환이 객체 자료형에도 적용되어야한다!
			why?) 객체자료형도 자료형이니까!!!!!!!!!!
4) 문제?
	사용자가 만든 자료형인 클래스간에도 같은 종류의 자료형이 있을 수 있는가?
	있다!!!!!! 상속을 이용하면 부모 자식간의 관계가 형성되고 부모 자식간의 관계를 우리는 같은 종류의 자료형으로 볼 수 있다.

	cmd창에 javadoc 하고 자바 파일 넣어주면 만들어짐 설명문
*/
public class Duck extends Bird{
							/*is  a*/
	String name="난 오리";
	String color;

	public Duck(String color){
		super("red");
		this.color = color;
	}

	public void canSwim(){
		System.out.println("수영을 잘함");
	}

}