package animal.birds;

/*조류의 최상위 객체를 정의한다...*/
public class Bird{
	String name="새";
	boolean hasWing=true;
	String color;

	public Bird(String color){
		this.color = color;
	}
	public void fly(){
		System.out.println(name+"가 날아다님");
	}
}