package monster; //이 클래스가 monster라는 디렉토리에 있음을 선언

//패키지에 넣은 클래스는 아무도 접근할 수 없기에 공개해 놓아야한다!!
public class PocketMon{
	String name="피카";
	int level = 99;
	
	public void sound(){
		System.out.println("피카추 너로 정했다");
	}
}