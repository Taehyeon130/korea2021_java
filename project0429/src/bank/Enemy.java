package bank;

class Enemy{
	public static void main(String[] args){
		//���������� �ܰ� ����
		Account acc = new Account();
		System.out.println("�Ǵ� ���� �� �ܰ� : "+acc.balance);
		acc.balance =-1000000;
		System.out.println("�Ǵ� ���� �� �ܰ� : "+acc.balance);
	}
}