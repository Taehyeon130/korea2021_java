package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gallery extends JFrame implements ActionListener{
	GalleryImage galleryImage;
	
	JPanel p_down;
	JButton bt_before;
	JButton bt_next;
	
	//갤러리에 사용할 데이터 즉 배열 준비!!
	String dir = "C:\\korea202102_javaworkspace\\app0512\\res\\images"; //디렉토리
	String[] arr= {"a.jpg","b.jpg","c.jpg","d.jpg","e.jpg","f.jpg","g.jpg","h.jpg","i.jpg","j.jpg"}; //파일명
	
	Toolkit kit;
	Image[] image=new Image[arr.length]; //배열 생성
	int index=0;//이미지 배열의 접근용 index
	
	public Gallery() {
		//생성
		galleryImage = new GalleryImage(); //이미지 나오는 패널 생성
		
		p_down = new JPanel();
		bt_before = new JButton("이전");
		bt_next = new JButton("다음");
		kit = Toolkit.getDefaultToolkit(); //인스턴스 얻기!! new 하지 않고도 java에서 이미 준비된 메서드
		
		for(int i=0;i<arr.length;i++) {
			image[i] = kit.getImage(dir+"/"+arr[i]);		
		}
		//이미지가 생성되었으므로 0번째 이미지를 default로 그려지게 하자 
		galleryImage.setImage(image[index]);
		
		//스타일 및 레이아웃
		galleryImage.setBackground(Color.cyan);
		p_down.setBackground(Color.gray);
		
		//조립
		add(galleryImage); //CENTER영역에 부착
		p_down.add(bt_before);
		p_down.add(bt_next);
		add(p_down,BorderLayout.SOUTH);
		
		//이전 버튼과 리스너 연결
		bt_before.addActionListener(this);
		//다음 버튼과 리스너 연결
		bt_next.addActionListener(this);
		
		//보이게
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		//하나의 actionPerformed메서드에서 여러 컴포넌트 즉 이벤트 소스를 구분해야한다
		if(e.getSource()==bt_before) {
//			System.out.println("이전");
			if(index>0) {
				index--; //이전 이미지				
			}else {
				JOptionPane.showMessageDialog(this, "이전 이미지가 없습니다");
			}
		}else if(e.getSource()==bt_next) {
//			System.out.println("다음");
			if(index<arr.length-1) {
				index++; //다음 이미지				
			}else {
				JOptionPane.showMessageDialog(this, "다음 이미지가 없습니다");
			}
		}
		System.out.println(index);
		
		//상세보기 객체에 변경된 이미지 보내주기
		galleryImage.setImage(image[index]);
		galleryImage.repaint();
		
	}
	
	public static void main(String[] args) {
		new Gallery();
	}

}
