package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChatClientA extends JFrame implements ActionListener, KeyListener{
	JButton bt_open; //대화 상대방을 띄우기 위한 버튼
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	ChatClientB chatClientB;
	ChatClientC chatClientC;
	
	
	public ChatClientA() {
		//생성
		bt_open = new JButton("열기");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(20);
		bt = new JButton("전송");
		
		//레이아웃, 스타일
		this.setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(new Color(250,255,0));
		
		//조립
		add(bt_open);
		add(scroll);
		add(t_input);
		add(bt);
		
		//이벤트리스너와 연결
		//특히 이벤트 리스너가 연결된 컴포넌트를 가리켜 이벤트 소스(Source)라 한다
		
		bt.addActionListener(this); //전송버튼
		bt_open.addActionListener(this); //open버튼
		//텍스트필드와 리스너 연결
		t_input.addKeyListener(this);
		
		//보여주기
		setBounds(300, 100, 310, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ENTER) {
			showText();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==bt_open) {  //열기버튼 누르면
			System.out.println("열기");
			chatClientB = new ChatClientB();
			chatClientC = new ChatClientC();
			
			//B창을 위한 설정(A,C의 정보를 넘겨야 함)
			chatClientB.setChatClientA(this);
			chatClientB.setChatClientC(chatClientC);
			
			//C창을 위한 설정(A,B의 정보를 넘겨야 함)
			chatClientC.setChatClientA(this);
			chatClientC.setChatClientB(chatClientB);
			
			//cb.setArea2(area);
		}else if(e.getSource()==bt) {  //전송버튼 누르면
//			System.out.println("전송");
			showText();
		}		
	}
	
	
	//전송 처리
	public void showText() {
		String msg = t_input.getText(); //(1) TextField값
		area.append(msg+"\n");	  //(2) TextArea에 누적
		t_input.setText("");		     //(3) 입력값 초기화
		
		//친구인 상대방 채팅창의 area의 append()
		chatClientB.area.append(msg+"\n");
		chatClientC.area.append(msg+"\n");
	}
	
	public static void main(String[] args) {
		new ChatClientA();
	}
}
