/*GUI ���α׷����� ������ �����찡 �־�� �Ѵ�
	���� �ڹ� ���� GUI���õ� ��Ű���� awt/swing���� ����
	javaFX(�ȵ���̵�� ���� ���)
*/
package gui;
import java.awt.Frame; //�����̳�
import java.awt.Button; //�Ϲ�
import java.awt.FlowLayout; 
import java.awt.TextField; //�Ϲ�
import java.awt.Checkbox; //�Ϲ�
import java.awt.TextArea;//�Ϲ�
import java.awt.Choice; //�Ϲ�

public class MyWin{
	//�ڹٿ��� ������� ���������� Frame�̶�� Ŭ������ ���
	public static void main(String[] args){
		Frame frame; //������ ��ü
		//��ü�� �ν��Ͻ��� ����. ���� frame���� �ʱ�ȭ�Ǿ����� �ʴ�.
		
		/*Frame�̶�� Ŭ������ ����� �������ذ��ε� ��� ������� ������
		  why??) �츮�� ������ Ŭ������ �ƴϹǷ� ...
		  [������ �������� ��ü ����ϴ�  Tip]
		  1) �ش� Ŭ������ ����ü ����/ �뵵�� ������ ����

		  2) �������ؼ��� �޸𸮿� �÷����Ѵ�
		      �޸𸮿� �ø�����, �� ��ü�� �Ϲ�����. �߻�����, �������̽� �������� ����!!
			  �Ϲ�Ŭ������ ��� : new�ϸ� �ȴ�
			  �߻�Ŭ������ ��� : �ڽ����� �ϼ� �� �ڽ��� new �ϸ� ��
			  �������̽��� ��� : �ڽ����� �ϼ� �� �ڽ��� new �ϸ� ��
		  
		  3) ��ü�� ������ �����Ǿ��ٸ�
			  - �Ϲ� Ŭ������ ��쿣 new������ �;��ϴ� �����ڸ� ����
		*/
		frame = new Frame(); //�������� �⺻������ ���� ������ �ʵ��� �Ӽ��� �����Ǿ��ִ�

		//������ �ȿ� ������ ��ư ����
		Button bt = new Button("��ư"); //Button is a Component

		//��ư ���� �� ��չ�ư�� ������ ������?
		//��� GUI���α׷��ֿ����� ȭ���� ��ġ����� �����ڰ� �����ؾ��Ѵ�
		//html���� absolute, relative�� �ֵ��� GUI�������α׷��ֿ����� ���� ��ٷӰ� �����ϴ�
		//���� �츮�� �ƹ��� ��ġ(Layout)�� �������� �ʾұ� ������ �ý����� �����ϴ� ����Ʈ ��ġ�� ����Ǿ� ���ϴ� ȿ���� ������ ����
		FlowLayout flow = new FlowLayout(); //������Ʈ�� �������� ��ġ�ϴ� ���̾ƿ� ��ü
		//�� �������� �������� �������� ���������� ����

		frame.setLayout(flow);//�����ӿ� ��ġ ������ ����

		//�Է� �ؽ�Ʈ �ڽ� �����Ͽ� �ٿ�����!!
		TextField t = new TextField(20);//20�ڸ� ���� ���ִٴ� ���� �ƴ϶� 20�� ũ���� ���̰� Ȯ���Ǵ� ��
	
		//üũ�ڽ� 
		Checkbox ch1 = new Checkbox("��ȭ");
		Checkbox ch2 = new Checkbox("���α׷���");
		Checkbox ch3 = new Checkbox("����");
		Checkbox ch4 = new Checkbox("����");
	
		//TextArea
		TextArea area = new TextArea(5,15);

		//html�� select �ڽ��� java������choice��� �Ѵ�
		Choice choice = new Choice();
		choice.add("Choose Your Email");
		 choice.add("naver.com");
		 choice.add("gmail.com");
		 choice.add("daum.net");

		frame.add(bt); //�����ӿ� ��ư ����
		frame.add(t); //�����ӿ� �ؽ�Ʈ �ڽ� ����
		frame.add(ch1); //�����ӿ� üũ�ڽ� ����
		frame.add(ch2);
		frame.add(ch3);
		frame.add(ch4);
		frame.add(area);
		frame.add(choice);

		//���� �����ڰ� ���ϴ� Ÿ�ӿ� ���� ���� ���ֵ��� �Ӽ��� �����ϴ� �޼��带 ȣ���غ���!!
		frame.setVisible(true);

		//ũ�⵵ ������� ������ ���ϴ� ũ��� �����찡 ������ ����
		frame.setSize(300,400);
	}

}
