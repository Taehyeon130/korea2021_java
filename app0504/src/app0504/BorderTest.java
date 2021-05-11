package app0504;

/*배치관리자 중 BorderLayout은 북,동,서,남,센터라는 방위를 갖는 객체방법
 	즉 5가지의 방위에 따른 위치가 이미 정해져있다.*/
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Button;

public class BorderTest {
	public static void main(String[] args) {
		Frame frame = new Frame("BorderLayout");
		
		BorderLayout layout = new BorderLayout(); //레이아웃 매니저 생성
		
		frame.setLayout(layout); //프레임에 BorderLayout 적용
		
		Button bt_north = new Button("North");
		Button bt_east =new Button("East");
		Button bt_south = new Button("South");
		Button bt_west = new Button("West");
		Button bt_center = new Button("Center");
		
		//방향값은 BorderLayout이 상수로 보유하고 있다
		//public static final int 대문자
		
	
		frame.add(bt_north,BorderLayout.NORTH);	//북쪽에 넣기
		frame.add(bt_east,BorderLayout.EAST);	//서쪽에 넣기
		frame.add(bt_south,BorderLayout.SOUTH);	//남쪽에 넣기
		frame.add(bt_west,BorderLayout.WEST);	//서쪽에 넣기
		frame.add(bt_center,BorderLayout.CENTER);	//중앙에 넣기
		
		frame.setSize(400,250);
		frame.setVisible(true);
	}
}
