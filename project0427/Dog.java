/*������ �������� �����غ���*/
class Dog{
		/*
		�������� ���� �� �ִ� �Ӽ����� ������ ����
		�ϳ��� Ŭ������ ������ �������� ������ ��ü�� �ݿ��� ����, �Ӽ��� ǥ���ߴٰ� �Ͽ�
		>> property(�Ӽ�)�� �Ѵ�
		*/
		int age = 5;
		String color="white"; //js�� ���� ���ڿ��� ��ü�� ó����
		String name = "Luca";

		//�Լ� �� �޼��� ����...js�� �ణƲ��(��ü���� Ʋ�� ����)
		//publid ���������� . void �� �޼��尡 ��ȯ���� ���� (=��ȯ���� ���� �Լ�)
		public String getName(){
			return name;
		}
		public int getAge(){
			return age;
		}
		public void run(){
			System.out.println(name+"�� �پ��");	
		}
	
}

