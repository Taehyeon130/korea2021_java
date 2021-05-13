package app0513.album;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

//썸네일에 이미지를 그리기위한 썸네일 패널
public class ThumbPanel extends JPanel implements MouseListener{
	Toolkit kit;
	Image image;
	int width = 50;
	int height=50;
	XCanvas can; //필요하면 보유~~ has a관계
	
	public ThumbPanel(String filename, XCanvas can) {
		this.setPreferredSize(new Dimension(width,height));
		kit = Toolkit.getDefaultToolkit(); //new 할 수 없음
		image = kit.getImage(filename);
		this.can = can; //넘겨받은 canvas 주소값을 멤버변수에 보관해놓자!!
		
//		image = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		this.addMouseListener(this); //패널인 나 자신과 리스너인 나 자신을 연결
	}
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0,width, height, this);
//		g.drawImage(image,0, 0, this);
	}


	public void mouseClicked(MouseEvent e) {
		//XCanvas에 파일의 정보 전달하자
		System.out.println("XCanvas에 전달할 이미지는 "+image);
		
		//XCanvas가 가진  setImage메서드를 호출!!
		can.setImage(image);
		can.repaint();
		
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}
