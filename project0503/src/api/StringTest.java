package api;

/*���ݱ����� �츮�� ������ Ŭ���� ���ַ� �н��� �ؿ� ������ ���� ���� �� sun���� �����ϴ� ������ Ŭ�������� �ַ� Ȱ����*/
//���ڿ� ó���� �߿��� ����� ����ϴ� StringŬ������ ���� �н�!!
class StringTest{
	public static void main(String[] args){
		//String�� ���� improt �� ���� �����Ƿ� ������ ���������� ��� �ʹ��� ���� ���Ǵ� ������ Ŭ������ 
		//�����ڰ� ������� �ʾƵ� �̹� �⺻������ import �Ǿ��ִ�...         java.lang��Ű���� �װ��̴�!!
		String s= new String("apple");//�����ε��� ���� ������ �� �ϳ���

		//stringŬ������ api document�� �̿��Ͽ�, �����ڴ� ���� ����� ������ ���ִ�.
		//���ڿ��� ���̸� �˼��ִ� api���
		System.out.println("���ڿ��� ���̴�"+s.length());

		//�빮�ڷκ�ȯ
		System.out.println(s.toUpperCase());

		//�ι�° p�� index�� ��ȯ
		System.out.println(s.lastIndexOf("p"));

		//���ϴ� ��°�� �ִ� ���� 1���� ����
		System.out.println(s.charAt(4));
	}
}