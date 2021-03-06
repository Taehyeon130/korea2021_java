package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientC extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	
//	private JTextArea area2; //ChatClientA가 보유한 JTextArea 주소값
	
	private ChatClientA chatClientA;
	private ChatClientB chatClientB;
	
	//생성자도 메서드 - 매개변수 전달 이용
	public ChatClientC() {
		//this.area2 = area2;
		//this.area2 = chatA.area;
		
		//생성 
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(24);
		
		//스타일, 레이아웃
		setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(Color.LIGHT_GRAY);
		
		//조립
		add(scroll);
		add(t_input);
		
		//이벤트 연결
		t_input.addKeyListener(this);
		
		
		//보여주기
		setBounds(600, 100+400, 300, 400);
		setVisible(true);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			showText();
		}
	}
	
	//setter
//	public void setArea2(JTextArea area) {
//		area2 = area;
//	}

	public void setChatClientA(ChatClientA chatClientA) {
		this.chatClientA = chatClientA;
	}
	
	public void setChatClientB(ChatClientB chatClientB) {
		this.chatClientB = chatClientB;
	}
	
	
	public void showText() {
		//1) 나의 텍스트 필드 값 구하기
		String msg = t_input.getText();
		
		//2) 나의 TextArea누적
		area.append(msg+"\n");
		
		//3) ChatA의 TextArea에도 누적
		chatClientA.area.append(msg+"\n");
		chatClientB.area.append(msg+"\n");
		
		//4) 입력값 다시 초기화
		t_input.setText("");
	}





}
