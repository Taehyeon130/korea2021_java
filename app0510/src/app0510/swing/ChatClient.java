package app0510.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	JTextArea area;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	
	public ChatClient() {
		//생성
		area = new JTextArea();
		p_south = new JPanel();
		t_input = new JTextField(18);
		bt_send = new JButton("전송");
		
		//스타일
		area.setBackground(Color.yellow);
		area.setEditable(false);//area 비활성화

		//조립
		add(area); //프레임의 센터에 부착
		p_south.add(t_input);
		p_south.add(bt_send);
		add(p_south,BorderLayout.SOUTH);
		
		//보여주기
		setSize(300,400);
		setVisible(true);
		
		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ChatClient();
	}
}
