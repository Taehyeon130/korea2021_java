/*GUI 프로그래밍은 무조건 윈도우가 있어야 한다
	따라서 자바 언어에서 GUI관련된 패키지는 awt/swing에서 지원
	javaFX(안드로이드와 많이 비슷)
*/
package gui;
import java.awt.Frame; //컨테이너
import java.awt.Button; //일반
import java.awt.FlowLayout; 
import java.awt.TextField; //일반
import java.awt.Checkbox; //일반
import java.awt.TextArea;//일반
import java.awt.Choice; //일반

public class MyWin{
	//자바에서 윈도우는 실제적으로 Frame이라는 클래스가 담당
	public static void main(String[] args){
		Frame frame; //윈도우 객체
		//객체의 인스턴스는 없다. 따라서 frame에는 초기화되어있지 않다.
		
		/*Frame이라는 클래스는 쓰라고 제공해준것인데 어떻게 사용할지 난감함
		  why??) 우리가 정의한 클래스가 아니므로 ...
		  [남에게 제공받은 객체 사용하는  Tip]
		  1) 해당 클래스가 도대체 뭔지/ 용도와 사용목적 조사

		  2) 쓰기위해서는 메모리에 올려야한다
		      메모리에 올리려면, 이 객체가 일반인지. 추상인지, 인터페이스 인지부터 조사!!
			  일반클래스인 경우 : new하면 된다
			  추상클래스인 경우 : 자식으로 완성 후 자식을 new 하면 됨
			  인터페이스인 경우 : 자식으로 완성 후 자식을 new 하면 됨
		  
		  3) 객체의 유형이 결정되었다면
			  - 일반 클래스의 경우엔 new다음에 와야하는 생성자를 조사
		*/
		frame = new Frame(); //프레임은 기본적으로 눈에 보이지 않도록 속성이 지정되어있다

		//윈도우 안에 부착할 버튼 생성
		Button bt = new Button("버튼"); //Button is a Component

		//버튼 부착 후 대왕버튼이 나오는 이유는?
		//모든 GUI프로그래밍에서는 화면의 배치방법을 개발자가 결정해야한다
		//html에서 absolute, relative가 있듯이 GUI응용프로그래밍에서는 더욱 까다롭고 엄격하다
		//현재 우리는 아무런 배치(Layout)를 결정하지 않았기 때문에 시스템이 제공하는 디폴트 배치가 적용되어 원하는 효과가 나오지 않음
		FlowLayout flow = new FlowLayout(); //컴포넌트를 선형으로 배치하는 레이아웃 객체
		//즉 수평으로 부착할지 수직으로 부착할지를 결정

		frame.setLayout(flow);//프레임에 배치 관리자 지정

		//입력 텍스트 박스 생성하여 붙여보자!!
		TextField t = new TextField(20);//20자만 넣을 수있다는 것이 아니라 20자 크기의 넓이가 확보되는 것
	
		//체크박스 
		Checkbox ch1 = new Checkbox("영화");
		Checkbox ch2 = new Checkbox("프로그래밍");
		Checkbox ch3 = new Checkbox("수영");
		Checkbox ch4 = new Checkbox("여행");
	
		//TextArea
		TextArea area = new TextArea(5,15);

		//html의 select 박스는 java에서는choice라고 한다
		Choice choice = new Choice();
		choice.add("Choose Your Email");
		 choice.add("naver.com");
		 choice.add("gmail.com");
		 choice.add("daum.net");

		frame.add(bt); //프레임에 버튼 부착
		frame.add(t); //프레임에 텍스트 박스 부착
		frame.add(ch1); //프레임에 체크박스 부착
		frame.add(ch2);
		frame.add(ch3);
		frame.add(ch4);
		frame.add(area);
		frame.add(choice);

		//따라서 개발자가 원하는 타임에 눈에 보일 수있도록 속성을 변경하는 메서드를 호출해보자!!
		frame.setVisible(true);

		//크기도 명시하지 않으면 원하는 크기로 윈도우가 보이지 않음
		frame.setSize(300,400);
	}

}
