package use;
import animal.Bird;

class UseBird{ //남이 접근하고자 하지 않기 때문에 굳이 public을 쓰지 않아도 됨
	public static void main(String[] args){
		//나와는 다른 경로에 있는 클래스인 Bird를 사용해본다!!
		Bird b = new Bird();
		b.fly();
	}
}