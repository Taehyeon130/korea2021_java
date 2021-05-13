package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//캔버스에 채워진 원을 하나 그리고 나서, 버튼에 의해 이 원이 x축 방향으로 이동하는 효과를 내보자
public class MoveTest extends JFrame implements ActionListener{
	JPanel p_north;
	MyButton bt;
	MyCanvas can; //커스터마이징된 캔버스
	int x=100; //원의 x좌표
	
	public MoveTest() {
		//생성
		p_north = new JPanel();
		bt = new MyButton("버튼");
		can = new MyCanvas(this);
		
		//스타일 및 레이아웃
		can.setBackground(Color.green);
		
		//조립
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH); //북쪽에 패널 부착
		add(can); //센터에 캔버스 부착
		
		//버튼과 리스너 연결
		bt.addActionListener(this);
		
		//보여주기
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	public void tick() { //물리량 변화
		x = x+10;
		//System.out.println(x);
	}
	
	public void render() { 
		//MyCanvas에 다시 그려 달라고 요청
		can.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		tick();	
		render();
	}
	
	public static void main(String[] args) {
		new MoveTest();
	}

}
