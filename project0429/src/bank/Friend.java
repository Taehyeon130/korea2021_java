package bank;

class Friend{
	public static void main(String[] args){
		Account acc = new Account();
		System.out.println("ģ�� ���� �� �ܰ� : "+acc.balance);
		acc.balance = acc.balance+8000;
		System.out.println("ģ�� ���� �� �ܰ� : "+acc.balance);

	}
}