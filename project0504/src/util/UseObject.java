package util;

class UseObject{
	public static void main(String[] args) {
		ObjectTest ot = new ObjectTest();
		String str = "monkey";

		//ot.test(); //존재하지 않는 메서드 호출

		boolean result = ot.equals(str);
		System.out.println(result);

		//위의 코드에서 equals는 ObjectTest라는 클래스 내에서 직접 정의한 적 없음
		//시스템에 의해 이미 존재하고 있다는 증명
		//원인 : 개발자가 명시하지 않더라도 자바언어의 최상위 어버이 클래스인 Object클래스로부터 상속받은 상태이기때문에
	}
}
