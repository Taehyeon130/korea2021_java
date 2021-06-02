package com.workin.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class MyCalendar extends JFrame{
	
	JPanel pp;
	JPanel p_hnorth;
	JButton bt_today;
	JLabel la_today;
	JPanel p_north;
	JButton bt_prev_y;
	JButton bt_prev;
	JLabel la_title;
	JButton bt_next;
	JButton bt_next_y;
	
	JPanel p_center; //날짜 박스 처리할 영역
	String[] dayArray= {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
	ScheduleForm form;

	
	//원하신 시점에 날짜 박스를 제어하기 위해서, 각 날짜 박스객체들을 배열에 담아놓자!!
	DateBox[] boxArray=new DateBox[dayArray.length*6];
	Calendar currentDate; //다음달, 이전달로 이동할 때 사용
	Calendar today = Calendar.getInstance();
	
	//int yy = currentDate.get(Calendar.YEAR);
	//int mm = currentDate.get(Calendar.MONTH);
	//int dd = currentDate.get(Calendar.DATE);
	
	int yy_t = today.get(Calendar.YEAR); //현재 연도 
	int mm_t = today.get(Calendar.MONTH); //현재 월 
	int dd_t = today.get(Calendar.DATE); //현재 일
	
	public MyCalendar() {
		
		//룩앤필이용해서 UI깔끔하게 
		try{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//LookAndFeel Windows 스타일 적용
			SwingUtilities.updateComponentTreeUI(this) ;
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e);
		}
		
		pp = new JPanel();
		p_hnorth= new JPanel();
		bt_today = new JButton("Today");
		la_today = new JLabel();
		p_north = new JPanel();
		bt_prev = new JButton("<");
		bt_prev_y = new JButton("<<");		
		la_title = new JLabel("연도 월 올 예정", SwingConstants.CENTER);
		bt_next = new JButton(">");
		bt_next_y = new JButton(">>");
		p_center = new JPanel();
		
		form = new ScheduleForm(this, "신규 일정 등록");
		
		//스타일
		la_title.setFont(new Font("Arial-Black", Font.BOLD, 20));
		la_title.setPreferredSize(new Dimension(400, 30));
		//p_hnorth.setPreferredSize(new Dimension(800,30));
		pp.setLayout(new GridLayout(2,1));
		p_hnorth.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); //위 왼쪽 아래 오른쪽
		p_north.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		
		//조립 
		p_hnorth.add(bt_today);
		p_hnorth.add(la_today);
		
		p_north.add(bt_prev_y);
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		p_north.add(bt_next_y);		
		
		pp.add(p_hnorth);
		pp.add(p_north);
		add(pp,BorderLayout.NORTH);
		add(p_center);
		
		getCurrentDate(); //현재날짜 객체 구하기
		setDateTitle();//달력 제목 달기
		createDay(); //요일생성
		createDate();//날짜생성
		printDate();//각 박스에 날짜 출력
		
		
		//이벤트 
		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevMonth();
			}
		});
		
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextMonth();
			}
		});
		bt_prev_y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevYear();
			}
		});
		bt_next_y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextYear();
			}
		});
		bt_today.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveToday();
			}
		});
		
		click();
			
		//보여주기
		setVisible(true);
		setSize(780, 780);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//현재날짜 구하기(프로그램 가동과 동시에 사용될 디폴트 날짜 객체) 
	public Calendar getCurrentDate() {
		currentDate = Calendar.getInstance();
		
		return currentDate;
	}
	
	//달력의 제목 즉, 날짜 출력 
	public void setDateTitle() {
		int yy = currentDate.get(Calendar.YEAR);
		int mm = currentDate.get(Calendar.MONTH);
		int dd = currentDate.get(Calendar.DATE);
		//제목에 출력
		la_title.setText(yy+"-"+getZeroString(mm+1));
		
		la_today.setText(yy+"/"+getZeroString(mm+1)+"/"+getZeroString(dd));
	}
	
	//요일 생성 
	public void createDay() {
		for(int i=0;i<7;i++) {
			DateBox dayBox=new DateBox(dayArray[i],Color.GRAY,100,70);
			p_center.add(dayBox); //센터에 부착!!
		}
	}
	
	//날짜 생성 
	public void createDate() {
		int yy = currentDate.get(Calendar.YEAR);
		int mm = currentDate.get(Calendar.MONTH);
		int dd = currentDate.get(Calendar.DATE);
		
		for(int i=0;i<dayArray.length*6;i++) {
			DateBox dateBox = new DateBox("", Color.orange, 100,100);
			p_center.add(dateBox); //센터에 부착!!
			//배열에 담아놓아야, 추후 필요할때 사용이 가능!!
			boxArray[i]=dateBox;
			
		}
	}
	
	//해당 월의 시작 요일 구하기!!
	//개발원리: 날짜 객체를 해당월의 1일로 조작한 후, 요일을 구한다!!
	//단 해당월과 연도는 매개변수로 호출자가 그 값을 결정할 수 있도록 메서드 정의하자
	//호출방법:  2월에 대한 정보를 구할 경우  getFirstDayOfMonth(2021, 2)
	public int getFirstDayOfMonth(int yy, int mm) {
		Calendar cal=Calendar.getInstance(); //날짜 객체 생성 
		cal.set(yy,mm, 1);//해당년도와 월의 1을로 조작!!
		
		return cal.get(Calendar.DAY_OF_WEEK)-1; //주의 js 에서의 습관이 있기에 요일은 0부터 시작하는 걸로..		
	}
	
	public int getFirstDate(int yy, int mm) { 
		Calendar cal = Calendar.getInstance();
		cal.set(yy,mm, 1); //0일이란 존재하지 않는 날짜이므로, 이전 월의 마지막날을 의미한다!!!
		return cal.get(Calendar.DATE);
	}
	
	//해당월이 몇일까지 있는지 구하기!!  8월 31일, 9월 30일
	//호출방법:  2월에 대한 정보를 구할 경우  getLastDate(2021, 2)
	public int getLastDate(int yy, int mm) { 
		Calendar cal = Calendar.getInstance();
		cal.set(yy,mm, 0); //0일이란 존재하지 않는 날짜이므로, 이전 월의 마지막날을 의미한다!!!
		return cal.get(Calendar.DATE);
	}
	
	//Box에 날짜 출력!!!
	public void printDate() {
		int n=1;
		int yy = currentDate.get(Calendar.YEAR);
		int mm = currentDate.get(Calendar.MONTH);
		int dd = currentDate.get(Calendar.DATE);
		
		System.out.println("currentDate값 : "+yy+"년"+(mm+1)+"월"+dd+"일");
		
		for(int i=0;i<boxArray.length;i++) {

			if(i>=getFirstDayOfMonth(yy,mm) ) {
				//각월의 총 날수까지만 출력되게..
				if(n <=getLastDate(yy, mm+1)) {
					boxArray[i].day=Integer.toString(n);
					boxArray[i].repaint(); //텍스트를 다시 그리자!! 즉 그래픽 갱신!!
					n++;	
				}
			}

		}
	}
	
	//기존의 Box에 그려진 스트링 모두 지우기 
	public void removeString() {
		for(int i=0;i<boxArray.length;i++) {
			boxArray[i].day="";
			boxArray[i].repaint(); //그림 다시 갱신
		}
	}
	
	
	//이전월 구하기
	public void prevMonth() {
		int yy = currentDate.get(Calendar.YEAR);
	int mm = currentDate.get(Calendar.MONTH);
		//현재 날짜 객체에 월을+1한다, 기왕이면 날짜는 1일로...
		currentDate.set(yy, mm-1,1); //yy, mm, dd
		
		removeString();//기존 날짜 지우기
		setDateTitle(); //달력 제목 바꾸기 
		printDate(); //날짜 출력하기
	}
	
	//이전 년도 구하기
	public void prevYear() {
		int yy = currentDate.get(Calendar.YEAR);
		int mm = currentDate.get(Calendar.MONTH);
		currentDate.set(yy-1, mm,1); //yy, mm, dd
		
		removeString();//기존 날짜 지우기
		setDateTitle(); //달력 제목 바꾸기 
		printDate(); //날짜 출력하기
	}

	
	//다음 월 구하기 
	public void nextMonth() {
		int yy = currentDate.get(Calendar.YEAR);
		int mm = currentDate.get(Calendar.MONTH);
		currentDate.set(yy, mm+1,1); //yy, mm, dd
		
		removeString();//기존 날짜 지우기
		setDateTitle(); //달력 제목 바꾸기 
		printDate(); //날짜 출력하기
	}
	
	//다음 년도 구하기
	public void nextYear() {
		int yy = currentDate.get(Calendar.YEAR);
		int mm = currentDate.get(Calendar.MONTH);
		currentDate.set(yy+1, mm,1); //yy, mm, dd
		
		removeString();//기존 날짜 지우기
		setDateTitle(); //달력 제목 바꾸기 
		printDate(); //날짜 출력하기
	}
	
	//오늘로 돌아오기
	public void moveToday() {
		/*
		int yy_t = today.get(Calendar.YEAR); //현재 연도 
		int mm_t = today.get(Calendar.MONTH); //현재 월 
		int dd_t = today.get(Calendar.DATE); //현재 일
		*/
		System.out.println(yy_t+"년"+(mm_t+1)+"월"+dd_t+"일");
		currentDate = new GregorianCalendar(yy_t,mm_t,dd_t);
	
		removeString();//기존 날짜 지우기
		setDateTitle(); //달력 제목 바꾸기 
		printDate(); //날짜 출력하기	
	}
	
	//한자리 숫자에 0붙이기
	public static String getZeroString(int n) {
		return (n<10)? "0"+n:Integer.toString(n);
	}
	
	//클릭
	public void click() {
		for(int i=0;i<boxArray.length;i++) {
			boxArray[i].addMouseListener(new ClickDate());
		}
	}
	
	class ClickDate extends MouseAdapter{
		public void mouseReleased(MouseEvent e) {
			form.setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
		new MyCalendar();
	}
}
