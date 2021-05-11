package app0504;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

/*프레임은 윈도우이기때문에 다른 컴포넌트 들을 올려놓을 수 있다...
	이때 어떤 방식으로 올려놓을지에 대해서는 배치 관리자라 불리는 클래스로 지원한다
	배치관리자의 종류
	★1. FlowLayout : 수평 또는 수직 방향으로 컴포넌트를 배치하며, 윈도우 크기에 따라 내부 컴포넌트들이 흘러다님 / 유동적임
	★2. BorderLayout : 동,서,남,북,센터의 방위로 배치
	★3. GridLayout : 격자형태로 배치(row,col)
	  4. GridBagLayout : 좌표이용(유지보수 복잡하고 까다로움)
	  5. CardLayout : 카드를 보여주는 방식으로, 주로 화면전환, 메뉴에 사용
*/

public class FlowTest {
	public static void main(String[] args) {
		Frame frame = new Frame();
		FlowLayout flow = new FlowLayout();
		frame.setLayout(flow);//프레임에 플로우 레이아웃 적용!!
		
		for(int i=0;i<20;i++) {
			Button bt = new Button(i+"th Button");			
			//프레임에 버튼 부착!!
			frame.add(bt);
		}
		//프레임의 크기 및 보이게 설정
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}
