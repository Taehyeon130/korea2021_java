//Account�ʹ� �ٸ� ��Ű������ �������� �ǽ�

package use;
import bank.Account;

class Hacker{
	public static void main(String[] args){
		//���� ���¸� �޸𸮿� �÷�����, ����� �峭��
		//bank.Account acc = new bank.Account(); //������ ��
		Account acc = new Account();
		//acc.balance = 300;

		//�Ʒ��� �ڵ�� ��Ű���� ������� balance������ private�̴ϱ� ���� �Ұ���
		//System.out.println("����"+acc.master+"�� ������ �ܰ��"+acc.balance); 

		//���ٰ���? > NoNo ��Ű���� �ٸ��ݾ�
		System.out.println("����� : "+acc.bankName);
		System.out.println("������ : "+acc.master);
		System.out.println("���¹�ȣ : "+acc.num);
	}
}