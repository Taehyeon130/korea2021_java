package api;

public class StringTest3{
	public static void main(String[] args){
		String s1="korea";
		String s2="korea";
		System.out.println(s1==s2); //s1과 s2는 레퍼런스 변수이기 때문에 비교연산자는 서로의 주소값을 비교하게 됨

		//내용을 비교하는 방법은?
		boolean result = s1.equals(s2); //s1과 s2가 내용이 같은가?
		System.out.println("두 문자열의 내용비교 결과 "+result);

	}
}
