package app0526.thread.ex4;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//모든 게임에 등장하는 객체가 가질 수 있는 보편적 요소들을 보유할 최상위 객체 선언
public abstract class GameObject {
	GamePanel gamePanel;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	Image img;
	
	public GameObject(GamePanel gamePanel,String path, int x, int y, int width, int height, int velX, int velY) {
		this.gamePanel = gamePanel;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.velX = velX;
		this.velY= velY;
		ImageIcon icon = this.gamePanel.imageManager.getScaledIcon(path, width, height);
		img = icon.getImage();
	}
	
	//채워넣지도 말아야하고 채워넣을 수도 없음!! 모든 오브젝트들이 다 다르니까
	public abstract void tick(); //장래의 자식이 누군지는 몰라도 자식이 완성하도록 미완성상태로 놓자!
	
	public abstract void render(Graphics g); //여기서의 g는 모든 게임 오브젝트가 그려질 JPanel의 paint메서드의 것!
}