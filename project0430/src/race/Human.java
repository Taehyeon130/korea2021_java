package race;

//인간을 정의
public class Human{
	int IQ=90;
	boolean hasName=true;

	/*
		public Human(){
			//디폴트 생성자
		}
	*/

	public Human(int IQ){
		this.IQ=IQ;
		System.out.println("Human의 초기화");
	}

	//생성자 오버로딩
	public Human(){ 
	
	}

	public void speak(){
		System.out.println("말할 수 있음");
	}

	public void drive(){
		System.out.println("운전할 수 있음");
	}
}