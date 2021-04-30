package traffic;

class Bus{
	String color;
	String seat;
	boolean camera;

	//생성자로 버스를 초기화 해보자
	public Bus(){
		color="green";
		seat="가죽시트";
		camera = true;
	}

	//일반 메서드로 버스를 초기화 해보자
	public void init(){
		color="pink";
		seat="인조가죽시트";
		camera = false;
	}

	public static void main(String[] args){
		Bus b = new Bus(); //만들어질때부터
		
		b.init(); //만들어진 것을 고치기 / 리모델링
	}
}