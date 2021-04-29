package use;
import bank.Account;

class Hacker{
	public static void main(String[] args){
		//은행 계좌를 메모리에 올려놓고, 맘대로 장난쳐
		//bank.Account acc = new bank.Account(); //가능은 함
		Account acc = new Account();
		//acc.balance = 300;
		System.out.println("현재"+acc.master+"이 보유한 잔고는"+acc.balance);
	}
}