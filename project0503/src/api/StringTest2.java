package api;

class StringTest2{
	public static void main(String[] args){
		//constant pool : ȿ������ ���ؼ� �ѹ� ������� ��ü�� �ٽ� �������� �ʴ°�
		//heap������ �ߺ��� ����� ������� ����

		//String�� ��ü������, �ʹ��� ���� ���̱� ������ ��ġ �⺻�ڷ���ó�� ��ü�� �����ϴ� ����� ������
		//�Ͻ���(=������) ������,implicit ������
		String str1 = "apple"; //��ü��
		String str2 = "apple";
		//���� ���� apple�� ����Ű�� �� �� 1���� �����Ǵ� ����
		//�ּҰ� �������� ���� �ּҸ� ����Ű�Ƿ� ��ġ �����ó�� ����� true�� ����
		System.out.println(str1==str2);//true

		//String�� Ŭ�����̹Ƿ� �̹����� ������ �̿�
		//�����(explicit)������
		
		String s1= new String("korea");
		String s2= new String("korea");
		//����� ���������� String��ü�� �����ϸ� ȿ���� ���θ� ������ �ʰ� constant pool�� ��������� �ʴ´�.
		//���� s1�� s2�� ����Ű�� �ִ� ��ü�� �ν��Ͻ��� �ٸ��Ƿ� ����� false
		System.out.println(s1==s2);//flase
	}
}