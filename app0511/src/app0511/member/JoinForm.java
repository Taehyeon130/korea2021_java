package app0511.member;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinForm extends JFrame implements ActionListener{
	JPanel p_title;
	JLabel la_title;
	JLabel la_id;
	JTextField t_id;
	JLabel la_pass;
	JPasswordField t_pass;
	JLabel la_hobby;
	JPanel p_hobby;
	JCheckBox[] ch_hobby;
	JPanel p_mail;
	JTextField t_mailId;
	JLabel la_at;
	Choice ch_server;
	JPanel p_recive;
	JLabel la_recive;
	CheckboxGroup g;
	JButton bt_regist;
	
	public JoinForm() {
		
		//생성
		p_title = new JPanel();
		la_title = new JLabel("회원가입");
		la_id = new JLabel("ID");
		t_id = new JTextField();
		la_pass = new JLabel("Pass");
		t_pass = new JPasswordField();
		la_hobby = new JLabel("취미 선택");
		p_hobby = new JPanel(); //취미  체크박스 담게될 패널
		ch_hobby = new JCheckBox[5]; //빈공간만 생성
		ch_hobby[0] = new JCheckBox("운동");
		ch_hobby[1] = new JCheckBox("잠자기");
		ch_hobby[2] = new JCheckBox("넷플릭스");
		ch_hobby[3] = new JCheckBox("프로그래밍");
		ch_hobby[4] = new JCheckBox("누워있기");
		p_mail = new JPanel();
		t_mailId = new JTextField();
		la_at = new JLabel("@");
		ch_server = new Choice();
		
		ch_server.add("gmail.com");
		ch_server.add("naver.com");
		ch_server.add("daum.net");
		ch_server.add("direct insert");
		
		//메일 수신여부 관련
		p_recive = new JPanel();
		la_recive = new JLabel("메일 수신");
		g = new CheckboxGroup(); //체크 박스를 그룹으로 묶기 위한 객체
		
		bt_regist = new JButton("가입");
		
		
		
		//스타일, 레이아웃
		setLayout(new FlowLayout());
		la_title.setFont(new Font("돋움",Font.BOLD,24));
		p_title.setPreferredSize(new Dimension(450,50));
		
		Dimension d = new Dimension(100,30);
		la_id.setPreferredSize(d);
		t_id.setPreferredSize(new Dimension(350,30));
		
		la_pass.setPreferredSize(d);
		t_pass.setPreferredSize(new Dimension(350,30));
		
		p_hobby.setPreferredSize(new Dimension(450,50));
		
		t_mailId.setPreferredSize(new Dimension(120,30));
		la_at.setPreferredSize(new Dimension(30,30));
		ch_server.setPreferredSize(new Dimension(150,30));
		
		la_recive.setPreferredSize(new Dimension(new Dimension(190,30)));
		p_recive.setPreferredSize(new Dimension(270,30));
		
		//조립
		p_title.add(la_title); //패널에 제목 올리기
		add(p_title);
		add(la_id);
		add(t_id);
		add(la_pass);
		add(t_pass);
		add(la_hobby);
		for(int i=0;i<ch_hobby.length;i++) {
			p_hobby.add(ch_hobby[i]);			
		}
		add(p_hobby);
		
		//메일 조립
		p_mail.add(t_mailId);
		p_mail.add(la_at);
		p_mail.add(ch_server);
		add(p_mail);
		
		//메일 수신 조립
		p_recive.add(new Checkbox("Yes",g,true));
		p_recive.add(new Checkbox("No",g,false));
		add(la_recive);
		add(p_recive);
		add(bt_regist);
		
		//이벤트 소스와 리스너 연결
		bt_regist.addActionListener(this);
		
		//보여주기 (화면 중앙으로 오게
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void checkValue() {
		//아이디에 대한 유효성 체크
		//String str = t_pass.getText();
		//System.out.println(str); //잘 나오지만 사용하지 않아야함
		
		//해결책?
		//char[] pass = t_pass.getPassword(); //char배열로 데이터 받은 후, 우리가 원하는 형태인 String으로 다시 변환..
		//char 배열을 String으로 변환해서 쓰자!!
		String data = new String(t_pass.getPassword());
		//System.out.println(data);
		//System.out.println(t_id.getText().length());

		//5개의 체크박스를 대상으로 조사를 실시!!
		int count=0;
		for(int i=0;i<ch_hobby.length;i++) {
			if(ch_hobby[0].isSelected()) {
				count++;
			}			
		}
		if(t_id.getText().length()==0) {
			JOptionPane.showMessageDialog(this,"아이디 입력하세요");
			t_id.requestFocus();//커서 올려놓기
		}else if(data.length()<8) {
			JOptionPane.showMessageDialog(this,"비밀번호 8자 이상 입력하세요");
			t_pass.requestFocus();//커서 올려놓기
		}else if(count<1){
			JOptionPane.showMessageDialog(this,"하나 이상의 취미 선택");
		}else {
			//오라클 DB입력 
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		checkValue();
	}

	public static void main(String[] args) {
		new JoinForm();
		
	}
}
