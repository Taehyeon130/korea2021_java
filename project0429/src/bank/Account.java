package bank;

//���� ����

//java�� Ŭ������ ���� ����� �����ϹǷ� ���Ȼ� ������ �ʾҴ� ������ �߻��� ���ֱ� ������ �̸� �����ϱ� ���� ���������ڶ�� ����ó���� ������
//�ڹ��� ���� ó���� ������ ���� �� 4�ܰ�� ������
// (����)        (��Ӱ���/���� ��Ű��)        (���� ��Ű����)       (���� ����� ���)
//public   <        protected        <       default       <      private

public class Account{
	String bankName="�������";
	String master="ȣ����";
	private int balance=5000; //����� �� ������ ���� ���� > enemy���� ���� �Ұ���
	String num="356-565-656-99";

	//�����Ϳ� ���� ���� ������ �������� ������ ����ڵ� ������� ���ϰԵ�
	//������ ����ڰ� ������ ���ִ� ��ġ ������ �ʿ���
	public void setBalance(int balance){
		this.balance = balance;
	}

	//���� ��ȯ�޾� �� �� �ִ� �޼��� ����(return�� �ִ� �޼���)
	public int getBalance(){
		return balance;
	}
}