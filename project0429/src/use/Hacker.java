package use;
import bank.Account;

class Hacker{
	public static void main(String[] args){
		//���� ���¸� �޸𸮿� �÷�����, ����� �峭��
		//bank.Account acc = new bank.Account(); //������ ��
		Account acc = new Account();
		//acc.balance = 300;
		System.out.println("����"+acc.master+"�� ������ �ܰ��"+acc.balance);
	}
}