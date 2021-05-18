package db.member;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * java에서는 이벤트 리스너의 메서드가 3개 이상 될때는 개발자 대신 메서드 재정의 의무를 짊어진 어댑트 클래스를 지원한다
 * 어댑터 클래스의 예)
 * KeyListener --> KeyAdapter
 * WindowListener --> WindowAdapter
 * MouseListener --> MouseAdapter
 * 
 * */

public class MyWindowAdapter extends WindowAdapter{
	//이미 Adapter가 재정의 의무를 다했기 때문에 우리는 필요한 메서드만 오버라이딩하면 된다!!
	public void windowClosing(WindowEvent e) {
		
	}
}
