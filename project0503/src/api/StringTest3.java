package api;

public class StringTest3{
	public static void main(String[] args){
		String s1="korea";
		String s2="korea";
		System.out.println(s1==s2); //s1�� s2�� ���۷��� �����̱� ������ �񱳿����ڴ� ������ �ּҰ��� ���ϰ� ��

		//������ ���ϴ� �����?
		boolean result = s1.equals(s2); //s1�� s2�� ������ ������?
		System.out.println("�� ���ڿ��� ����� ��� "+result);

	}
}
