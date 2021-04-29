package bank;

class Friend{
	public static void main(String[] args){
		Account acc = new Account();
		System.out.println("친구 조작 전 잔고 : "+acc.balance);
		acc.balance = acc.balance+8000;
		System.out.println("친구 조작 후 잔고 : "+acc.balance);

	}
}