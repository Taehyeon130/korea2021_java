class Phone{
	
	int price=5000;
	String name="G21";
	static String company="Samsung"; //static�� '��������'�̶� ���� �����ڶ� �Ҹ���
															//static���� ����� ����, �޼���� new�Ҷ� �ش� �ν��Ͻ��� �Ҽӵ��� �ʴ´�
															//���� ���� Ŭ������ �����ϰ� �ȴ�.
															//static���� ����� ��������� Ŭ���� ������ �Ѵ�.

	public void ring(){
		System.out.println("���� �����");
	}

	//�����
	public static void main(String[] args){
		String c = Phone.company//Ŭ������ ������ Ŭ���� ������ �̷��� ���� (main�� �ٸ����� ���� ��)
		String c = company //���� ���� �����Ѵٸ� �̷��� �����
		Phone p1 = new Phone();
	}
}