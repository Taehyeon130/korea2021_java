package bank;

//계좌 정의

//java는 클래스간 서로 사용이 가능하므로 보안상 뜻하지 않았던 문제가 발생할 수있기 때문에 이를 보완하기 위해 접근제한자라는 보안처리를 지원함
//자바의 보안 처리는 다음과 같이 총 4단계로 구성됨
// (공개)        (상속관계/같은 패키지)        (같은 패키지만)       (나만 사용)
//public   <        protected        <       default       <   private

public class Account{
	String bankName="기업은행";
	String master="호빵맨";
	private int balance=5000; //멤버만 이 변수에 접근 가능
	String num="356-565-656-99";
}