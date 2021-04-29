package bank;

class Enemy{
	public static void main(String[] args){
		//악의적으로 잔고 감소
		Account acc = new Account();
		System.out.println("악당 조작 전 잔고 : "+acc.balance);
		acc.balance =-1000000;
		System.out.println("악당 조작 후 잔고 : "+acc.balance);
	}
}