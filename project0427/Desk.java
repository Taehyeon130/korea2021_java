public class Desk {
	int x;
	static int y;
	
	{ //A
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
	
	static { //B, 실행시 동작한다!! main메서드 호출시 동작함!!
		for(int i=0;i<20;i++){
			y++;
		}
	}
	                              
	public static void main(String[] args){
		//System.out.println(x); //C 메모리 올라온적도 없고 static영역에서 레퍼런스 변수없이 x를 접근할 수도 없다
		int a=new Desk().x; //D
		System.out.println(a); //E
		System.out.println(y); //F
		
	}
}