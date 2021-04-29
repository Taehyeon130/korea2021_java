//Account와는 다른 패키지에서 접근제한 실습

package use;
import bank.Account;

class Hacker{
	public static void main(String[] args){
		//은행 계좌를 메모리에 올려놓고, 맘대로 장난쳐
		//bank.Account acc = new bank.Account(); //가능은 함
		Account acc = new Account();
		//acc.balance = 300;

		//아래의 코드는 패키지와 상관없이 balance변수가 private이니까 접근 불가능
		//System.out.println("현재"+acc.master+"이 보유한 잔고는"+acc.balance); 

		//접근가능? > NoNo 패키지가 다른잖아
		System.out.println("은행명 : "+acc.bankName);
		System.out.println("계좌주 : "+acc.master);
		System.out.println("계좌번호 : "+acc.num);
	}
}