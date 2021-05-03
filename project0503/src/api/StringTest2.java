package api;

class StringTest2{
	public static void main(String[] args){
		//constant pool : 효율성을 위해서 한번 만들어진 객체를 다시 생성하지 않는것
		//heap영역에 중복된 상수를 허용하지 않음

		//String은 객체이지만, 너무나 많이 쓰이기 때문에 마치 기본자료형처럼 객체를 생성하는 방법을 지원함
		//암시적(=묵시적) 생성법,implicit 생성법
		String str1 = "apple"; //객체임
		String str2 = "apple";
		//서로 같은 apple을 가리키게 됨 즉 1개만 생성되는 것임
		//주소값 비교이지만 같은 주소를 가리키므로 마치 내용비교처럼 결과가 true가 나옴
		System.out.println(str1==str2);//true

		//String도 클래스이므로 이번에는 생성자 이용
		//명시적(explicit)생성법
		
		String s1= new String("korea");
		String s2= new String("korea");
		//명시적 생성법으로 String객체를 생성하면 효율성 여부를 따지지 않고 constant pool에 만들어지지 않는다.
		//따라서 s1과 s2는 가리키고 있는 객체의 인스턴스가 다르므로 결과가 false
		System.out.println(s1==s2);//flase
	}
}