package app0512.graphic;

import java.awt.Graphics;

import javax.swing.JButton;

public class MyButton extends JButton{
	//컴파일러에 의한 디폴트 생성자를 사용하지 않고 개발자가 나섬
	
//	public MyButton() {
//		super("버튼");
//	}
	
	public MyButton(String label) {
		super(label);
	}
	
	//개발자가 직접 그림을 뺏어서 그려보자!!
	/*
	public void paint(Graphics g) {
		System.out.println("버튼버튼");
	}
	*/
}
