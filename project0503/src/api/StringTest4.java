package api;

public class StringTest4{
	public static void main(String[] args){
		//String 클래스를 가리켜 immutable(불변)의 속성이 있음
		String s1="korea";
		s1 = s1+" vs usa";

		System.out.println(s1);

		//무서운 코드
		//아래의 코드는 result가 변경되는 것이 아니라 result와 같은 값에 계속 새로운 문자열이 생성되는것
		//따라서 총 100개 이상의 문자열 상수가 메모리에 올라옴
		String result="";
		for(int i=0;i<100;i++){
			result +="apple"+i;
		}

		//위 문제를 해결하려면 수정가능한 문자열 처리관련 api를 지원받으면 된다
		// StringBuffer, StringBuilder 객체를 이용
		StringBuffer sb = new StringBuffer();
		sb.append("야호");
		sb.append("나는");
		sb.append("자바가");
		sb.append("좋아");
		System.out.println(sb.toString());
	}
}