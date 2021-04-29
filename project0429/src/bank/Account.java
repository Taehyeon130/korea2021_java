package bank;

//계좌 정의

//java는 클래스간 서로 사용이 가능하므로 보안상 뜻하지 않았던 문제가 발생할 수있기 때문에 이를 보완하기 위해 접근제한자라는 보안처리를 지원함
//자바의 보안 처리는 다음과 같이 총 4단계로 구성됨
// (공개)        (상속관계/같은 패키지)        (같은 패키지만)       (나의 멤버만 사용)
//public   <        protected        <       default       <      private

public class Account{
	String bankName="기업은행";
	String master="호빵맨";
	private int balance=5000; //멤버만 이 변수에 접근 가능 > enemy에서 접근 불가능
	String num="356-565-656-99";

	//데이터에 대한 직접 접근을 막았으나 선의의 사용자도 사용하지 못하게됨
	//선의의 사용자가 접근할 수있는 장치 마련이 필요함
	public void setBalance(int balance){
		this.balance = balance;
	}

	//값을 반환받아 갈 수 있는 메서드 정의(return이 있는 메서드)
	public int getBalance(){
		return balance;
	}
}