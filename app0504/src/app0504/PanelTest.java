package app0504;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class PanelTest {
	public static void main(String[] args) {
		//그래픽 api 중 Panel을 학습한다
		Frame frame =  new Frame("Pannel Test");
		
		//아래처럼 인스턴스 자체를 넣는 경우는? 
		//굳이 BorderLayout이라는 객체의 레퍼런스가 사용할 필요가 없는 경우 = 1회성일 때 > 변수는 필요가 없음
		frame.setLayout(new BorderLayout());
		Button bt = new Button("I'm Button");
		//frame.add(bt); //개발자가 Border의 5가지 방향 중 선택하지 않았을 경우 Default 방향은? CENTER
		//결론 : 버튼은 혼자만 존재하기 때문에 북,동,서,남의 모든 방위를 혼자 독차지 > 대왕버튼
		
		Panel p = new Panel(); //컴포넌트 중 무언가를 올려놓을 수 있는 패널을 의미 
		//패널은 컨테이너의 자식이기 때문에 다른 컴포넌트들을 포함할 수 있는 능력이 있고 또한 container이기에 배치관리자도 사용이 가능하다
		//왕버튼 해결책) Frame에 Panel을 부착하고 이 Panel에 FlowLayout을 적용하여 최종적으로 Button을 패널에 부착하면 된다!!
		
		p.setBackground(Color.GRAY); //패널에 배경색 적용 
		frame.add(p); //윈도우에 판자 붙이기!!
		
		//버튼을 패널에 부착해보자!! 참고로 개발자가 Panel의 배치관리자를 지정하지 않으면 Default는 바로 FlowLayout(컴포넌트 본연의 크기가 유지됨)
		p.add(bt);
		
		frame.setSize(300,250);
		frame.setVisible(true);
	}
}

/*
	모든 컴포넌트는 다른 컴포넌트를 포함할 수 있는 능력을 기준으로 크게 2가지로 분류됨
 	포함을 하는지(컨테이너) - container
 	포함을 당하는지(일반 컴포넌트) - visual component
*/
