package app0510.gugudan;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GuGuDan extends JFrame{
	JTextField t_input;//레퍼런스 변수 주소값만 알면 다른 곳에서 접근 가능해
	JTextArea t_area;
	JButton bt;
	
	public GuGuDan() {
		//생성
		t_input = new JTextField(20);
		t_area = new JTextArea("원하시는 단 입력");
		bt = new JButton("출력");
		
		//비활성화
		t_area.setEditable(false);
		
		//대왕을 막기 위함
		this.setLayout(new FlowLayout());
		
		//조립
		this.add(t_area);
		this.add(t_input);
		this.add(bt);
		
		//버튼과 리스너 연결
		GuGuAction ge = null;
		bt.addActionListener(ge = new GuGuAction(t_input));
		
//		ge.callMe(33); //call by value
//		ge.callMe("yaho"); //call by reference
//		ge.callMe(bt); //call by reference
//		ge.callMe(t_input); //call by reference
		
	
		
		//보여주기
		this.setVisible(true);
		this.setSize(250,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GuGuDan();
	}

}
