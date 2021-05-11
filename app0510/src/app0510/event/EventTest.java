package app0510.event;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest extends JFrame{
	JTextField t_input;
	JButton bt;
	
	public EventTest() {
		t_input = new JTextField(20);
		bt = new JButton("버튼이닷");
		
		this.setLayout(new FlowLayout()); //FlowLayout으로 진행
		
		//조립
		add(t_input);
		add(bt);
		
		//컴포넌트와 리스너와의 연결!!
		//선언이 test(int x, String k, ActionListener l); 인 경우
		//			test(3,"apple",new ActionControl());
		//이벤트 구현방법 : 미완성 객체를 구현 한 후, 해당 컴포넌트와 연결!!!
		
		bt.addActionListener(new ActionControl());
		
		//텍스트필드와 키리스너와의 연결
		t_input.addKeyListener(new KeyControl());
		
		this.addMouseListener(new MouseControl());
		
		//프레임 본체를 대상으로 윈도우 리스너와 연결
		this.addWindowListener(new WindowControl());
		
		//보여주기
		setSize(250,150);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new EventTest();
	}
}
