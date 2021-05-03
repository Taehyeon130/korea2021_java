package api;

/*지금까지는 우리가 정의한 클래스 위주로 학습을 해옴 하지만 실제 개발 시 sun에서 지원하는 유용한 클래스들을 주로 활용함*/
//문자열 처리시 중요한 기능을 담당하는 String클래스에 대해 학습!!
class StringTest{
	public static void main(String[] args){
		//String도 원래 improt 한 적이 없으므로 에러가 나야하지만 사실 너무나 많이 사용되는 유용한 클래스는 
		//개발자가 명시하지 않아도 이미 기본적으로 import 되어있다...         java.lang패키지가 그것이다!!
		String s= new String("apple");//오버로딩된 여러 생성자 중 하나임

		//string클래스의 api document를 이용하여, 개발자는 여러 기능을 참조할 수있다.
		//문자열의 길이를 알수있는 api기능
		System.out.println("문자열의 길이는"+s.length());

		//대문자로변환
		System.out.println(s.toUpperCase());

		//두번째 p의 index를 반환
		System.out.println(s.lastIndexOf("p"));

		//원하는 번째에 있는 문자 1개를 추출
		System.out.println(s.charAt(4));
	}
}