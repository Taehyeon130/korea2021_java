package traffic;


//java������ ���� �޼��� ���� ����� ���ִ�
//�޼������ ������ ������ ��ġ�ϰ� �����ϴ� ���� �ƴ϶� �Ű������� �ڷ����� ������ Ʋ���� �ϸ� �ߺ����Ƿ� �������� ����
//�����ε�(Overroading) - �޼��� ��ø
//�� �����ڰ� ����� �������� �޼��带 ������ ��� ū ���̰� �������� �ұ��ϰ� �޼������ ���� �ٸ��� ����ϴ� �������� �ؼ��� �� �ִ�.

class Car{
	public void run(){ 
		System.out.println("�ڵ��� �غغ�");
	}

	public void run(int vel){
		System.out.println("�ڵ��� �ɱ� �غغ�");
	}

	public void run(boolean flag){
		System.out.println("......");
	}

}