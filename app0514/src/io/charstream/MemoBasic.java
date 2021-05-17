package io.charstream;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//메모장 편집기의 기능 중 읽기 기능만을 구현해보자!!
public class MemoBasic extends JFrame{
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	
	public MemoBasic() {
		//생성
		bt = new JButton("Load");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		//조립
		add(bt,BorderLayout.NORTH);
		add(scroll);
		
		setBounds(500,100,500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}	
	
	public static void main(String[] args) {
		new MemoBasic();
	}
}
