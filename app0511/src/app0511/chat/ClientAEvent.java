package app0511.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//ChatClientA에 대한 이벤트 처리 클래스 정의
public class ClientAEvent implements ActionListener,KeyListener{
	private JTextField t_input;
	private JTextArea area;
	private JButton bt,bt_open;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//이 베서드의 인수로 전달되는 e변수에는 사용자가 일으킨 Action 관련한 모든 ~~ 정보가 들어있다..
		//ex) who, where, when
		JButton btn = (JButton)e.getSource(); //형변환
		//System.out.println(btn);
		if(btn ==bt) {
			System.out.println("전송 원함");
			showText();
		}else if(btn== bt_open) {
			System.out.println("열기 원함");
		}
	
		//String msg = t_input.getText();
		//System.out.println(msg);
	}
	
	//setter
	public void setT_input(JTextField t_input) {
		this.t_input = t_input;
	}
	
	//setter
	public void setArea(JTextArea area) {
		this.area = area;
	}
	public void setBt(JButton bt) {
		this.bt=bt;
	}
	public void setBt_open(JButton bt_open) {
		this.bt_open=bt_open;
	}
	
	
	
	//채팅창에 반영하기
	public void showText() {
		//(1) JTextField의 값 얻기
		String msg = t_input.getText();
		
		//(2) JTextArea에 값 누적
		area.append(msg+"\n");
		
		//모든 입력값 초기화
		t_input.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	//KeyEvent 객체가 아래의 메서드의 매개변수로 전달되면 
	//개발자는 원하는 정보를 추출하여 프로그램에서 사용하면 됨
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println(key);
		
		if(key==KeyEvent.VK_ENTER) { //상수를 이용하면 직관성!
			showText();			
		}
	}

}
