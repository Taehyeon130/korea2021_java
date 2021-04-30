package animal.birds;

class UseDuck{
	public static void main(String[] args){
		//오리 한마리를 메모리에 올리고(인스턴스 생성), canSwim메서드 호출하기
		Duck d = new Duck("Yellow");
		d.canSwim();

		//객체형도 자료형이다
		//새>오리
		Bird b = new Bird();
		b=d; //가능 
		//하위가 부모를 가리킬 순 없으니 반대로는 불가능함
	
	//byte short int long : 숫자형은 서로 같은 종류의 자료형
	//즉 같은 종류의 자료형이기때문에 형변환 가능
	byte b=5;
	int k=b;



	}
}