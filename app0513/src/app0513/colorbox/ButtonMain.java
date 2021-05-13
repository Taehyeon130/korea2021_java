package app0513.colorbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonMain extends JFrame implements ActionListener{
	JPanel p_north;
	JTextField t_ea;
	JButton bt_create; //일괄생성
	JButton bt_create2; //낱개생성
	JButton bt_bg;
	JPanel p_center;
	
	//대부분의 응용프로그램에서는 배열선언시 반드시 그 크기를 명시해야한다.
	JButton[] btnArray;
	int count=0; //버튼에 붙여질 순번
	
	//배열이 나쁘진 않지만 선언시 반드시 그 크기를 정해야한다는 것은 프로그램 개발시 유연성에 있어서는 불편하다
	//그렇다면 자바스크립트 처럼 배열의 크기가 동적으로 늘어날 수있는 형태의 객체는 없을까?  당연히 있음
	
//	JButton[] btnArray2 = new JButton[1000]; //낱개로 생성된 버튼을 담을 배열
	
	//배열과 거의 같지만 크기가 동적으로 변할 수 있는 컬렉션프레임웍 중 List계열을 이용해보자!!
	ArrayList<JButton> list = new ArrayList<JButton>(); //현재는 사이즈 0, but 늘어날 수있음
	
	public ButtonMain() {
		//생성
		p_north = new JPanel();
		t_ea = new JTextField(10);
		bt_create = new JButton("일괄 생성");
		bt_create2 = new JButton("낱개 생성");
		bt_bg = new JButton("배경색");
		p_center = new JPanel();
	
		//스타일, 레이아웃
		p_north.setPreferredSize(new Dimension(500,50));
		p_center.setBackground(Color.pink);
	
		//조립
		p_north.add(t_ea);
		p_north.add(bt_create);
		p_north.add(bt_create2);
		p_north.add(bt_bg);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		//리스너와 연결
		bt_create.addActionListener(this);
		bt_create2.addActionListener(this);
		bt_bg.addActionListener(this);
	
		//보이기
		setBounds(500,100,500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//사용자가 입력한 개수만큼 버튼을 생성한다.
	public void create() {
		//(1) 텍스트필드의 값 구하기
		int ea = Integer.parseInt(t_ea.getText()); //강제 형변환
		btnArray = new JButton[ea]; //배열의 크기 결정, 이때 배열을 생성
		
		
		//(2) 개수만큼 버튼을 생성하여 p_center에 붙이기
		for(int i=0;i<ea;i++) {
			JButton bt = new JButton("버튼"+i);
			p_center.add(bt);
			btnArray[i]=bt;
		}
		p_center.updateUI();
	}
	
	public void createOne() {
		JButton bt = new JButton("버튼"+count);
		p_center.add(bt); //센터 영역에 버튼 추가
		p_center.updateUI();
		//추후 배경색 버튼을 눌렀을 때 생성된 모든 버튼의 색상을 변경하기 위해서는 반복문 필요
		//반복문을 적용하려면 배열형태 or 규칙이 있어야함
		list.add(bt);
		count++;
	}
	
	public void setBg() {
//배열사용시
//		for(int i=0;i<btnArray.length;i++) {
//			btnArray[i].setBackground(Color.red);
//		}
		
		//List 사용시
		for(JButton btn:list) {
			btn.setBackground(Color.red);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt_create) { //일괄 생성
			create();
		}else if(e.getSource()==bt_create2){//낱개로 생성
			createOne();
		}else if(e.getSource()==bt_bg) {
			setBg();
		}
	}
	
	public static void main(String[] args) {
		new ButtonMain();
	}

	
}
