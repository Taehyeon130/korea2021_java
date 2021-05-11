package app0510.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

//LoginForm1의 예제에서 메인메서드 안에 변수를 몰아놓고, 즉 지역변수로 객체들을 처리하고 있다
//이번엔 oop언어의 is a, has a 관계를 활용하여 객체를 정의해보자

public class LoginForm2 extends Frame{
								  /*is a*/


	/*has a*/
	Label la_id;
	Label la_pass;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_join;
	
	Panel p_center;
	Panel p_south;
	
	
	//이 윈도우인 즉 로그인폼이 메모리에 생성될 때 해당 부품들도 같이 생성시키려면 생성자 메서드를 적극 활용해야함
	public LoginForm2() {
		
		super("Login Form style2");
		//부품 생성
		la_id = new Label("ID");
		la_pass = new Label("PWD");
		t_id = new TextField(20);
		t_pass = new TextField(20);
		bt_login = new Button("Login");
		bt_join = new Button("Join");
		p_center = new Panel();
		p_south = new Panel();
		
		//스타일 설정
		la_id.setPreferredSize(new Dimension(110,35));
		t_id.setPreferredSize(new Dimension(110,35));
		la_pass.setPreferredSize(new Dimension(110,35));
		t_pass.setPreferredSize(new Dimension(110,35));
		
		//조립
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		
		p_south.add(bt_login);
		p_south.add(bt_join);
		
		//패널을 윈도우 센터에 부착
		this.add(p_center);
		this.add(p_south,BorderLayout.SOUTH);
		
		//현재 클래스가 Frame을 상속받은 자식이므로 Frame이 보유한 메서드를 내 것처럼 사용할 수 있음
		this.setSize(330,155);
		this.setVisible(true);
		
		//윈도우에 제목달기 - 방법 1 부모의 일반 메서드 이용
		//this.setTitle("Login Form");
		
		//방법 2 부모의 생성자 이용
		//super("Login Form style2");
		
	}
}
