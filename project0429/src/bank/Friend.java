package bank;

class Friend{
	public static void main(String[] args){
		Account acc = new Account();
		//System.out.println("ģ�� ���� �� �ܰ� : "+acc.balance);
		//acc.balance = acc.balance+8000;

		//������ ���� ���������� �ƴ϶� �޼��� ȣ��� �����͸� �����غ���
		acc.setBalance(9000);
		
		//System.out.println("ģ�� ���� �� �ܰ� : "+acc.balance);
		System.out.println("�ܰ� : "+acc.getBalance());

		//���� friendŬ������ Account�� ���� Ŭ������ ���� ��Ű���� �����Ƿ� Account�� ������ default���������� �ɷ��ִ� ��� ������ ����� ������ ����
		System.out.println("����� : "+acc.bankName);
		System.out.println("������ : "+acc.master);
		System.out.println("���¹�ȣ : "+acc.num);
	}
}