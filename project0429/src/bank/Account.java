package bank;

//���� ����

//java�� Ŭ������ ���� ����� �����ϹǷ� ���Ȼ� ������ �ʾҴ� ������ �߻��� ���ֱ� ������ �̸� �����ϱ� ���� ���������ڶ�� ����ó���� ������
//�ڹ��� ���� ó���� ������ ���� �� 4�ܰ�� ������
// (����)        (��Ӱ���/���� ��Ű��)        (���� ��Ű����)       (���� ����� ���)
//public   <        protected        <       default       <      private

public class Account{
	private String bankName="�������";
	private String master="ȣ����";
	private int balance=5000; //����� �� ������ ���� ���� > enemy���� ���� �Ұ���
	private String num="356-565-656-99";

	//�����Ϳ� ���� ���� ������ �������� ������ ����ڵ� ������� ���ϰԵ�
	//������ ����ڰ� ������ ���ִ� ��ġ ������ �ʿ���
	public void setBalance(int balance){ //�����(���ۿ�) setter
		this.balance = balance;
	}

	//���� ��ȯ�޾� �� �� �ִ� �޼��� ����(return�� �ִ� �޼���) getter
	public int getBalance(){ //������������ �뵵
		return balance;
	}

	//�����ʹ� ��ȣ�ϰ� �� �����͸� ����� ���ִ� �޼��带 ��������� ������ �����ϹǷ� �̷��� ����ȭ, ����ȭ�� �޼��� ���� ����� setter,getter���Ѵ�.
	//setter,getter�� �޼��� ���� ��Ģ�� �ִ�.... get ����, set ����
	//������ ù ö�ڴ� �빮�ڷ� �Ѵ�.

	public void setMaster(String master){
		this.master = master;
	}

	public String getMaster(){
		return master;
	}

	public void setBankName(String bankName){
		this.bankName = bankName;
	}

	public String getBankName(){
		return bankName;
	}

	public void setNum(String num){
		this.num = num;
	}

	public String getNum(){
		return num;
	}
}