package traffic;

class Bus{
	String color;
	String seat;
	boolean camera;

	//�����ڷ� ������ �ʱ�ȭ �غ���
	public Bus(){
		color="green";
		seat="���׽�Ʈ";
		camera = true;
	}

	//�Ϲ� �޼���� ������ �ʱ�ȭ �غ���
	public void init(){
		color="pink";
		seat="�������׽�Ʈ";
		camera = false;
	}

	public static void main(String[] args){
		Bus b = new Bus();
		
		b.init();
	}
}