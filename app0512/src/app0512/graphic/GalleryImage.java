package app0512.graphic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

//갤러리의 큰 이미지 나올 패널
public class GalleryImage extends JPanel{

	private Image image;
	//누군가에 의해 이미지를 넘겨받으려면 메서드를 준비해놓아야한다
	
	//setter
	public void setImage(Image image) {
		this.image = image;
		this.image = this.image.getScaledInstance(500, 340, Image.SCALE_SMOOTH);
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}

}
