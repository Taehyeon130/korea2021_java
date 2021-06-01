package calender;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

class CalenderDataManeger{
	//참조의 용도로만 사용됨
	static final int CAL_WIDTH = 7; //달력의 가로 
	static final int CAL_HEIGHT = 6; //달력의 세로
	int calDates[][] = new int[CAL_HEIGHT][CAL_WIDTH]; //달력 배열 
	int calYear; //년도
	int calMonth; //월
	int calDayOfMon; //일
	final int calLastDateOfMonth[]= {31,28,31,30,31,30,31,31,30,31,30,31}; //달의 마지막 일
	int calLastDate;
	Calendar today = Calendar.getInstance();
	Calendar cal; //현재 달에서 다음달, 이전달로 이동할때 생성하는 달력
	
	public CalenderDataManeger() {
		setToday();
	}
	
	//오늘날짜set
	public void setToday() {
		calYear = today.get(Calendar.YEAR); //오늘의 년도
		calMonth = today.get(Calendar.MONTH); //오늘의 달
		calDayOfMon = today.get(Calendar.DAY_OF_MONTH);//오늘의 일
		makeCalData(today);
	}
	
	
	//Calendar를 매개변수로 받아서 달력을 생성함
	private void makeCalData(Calendar cal) {
		//DAY_OF_WEEK >> 요일을 구할수있음(월:1,화:2,수:3....)
		//1일의 위치
		int calStartingPos = (cal.get(Calendar.DAY_OF_WEEK)+7-(cal.get(Calendar.DAY_OF_MONTH))%7)%7;
		//마지막 날의 위치
		if(calMonth ==1) calLastDate = calLastDateOfMonth[calMonth] + leapCheck(calYear);
		else calLastDate = calLastDateOfMonth[calMonth];
		
		//달력 배열 초기화
		for(int i=0;i<CAL_HEIGHT;i++) {
			for(int j=0;j<CAL_WIDTH;j++) {
				calDates[i][j] = 0; //초기화됨
			}
		}
		
		//달력 배열 값 채워넣기
		for(int i=0, num=1, k=0; i<CAL_HEIGHT;i++) {
			if(i==0) k = calStartingPos; //첫번째 줄일때 k의 값을 1일의 위치 값으로 지정
													//만약에 calStartinPos의 값이 2라면 k의 값은 2
													//j는 2부터 7미만까지 증가하고 그 위치에 num의 값을 증가시키면서 대입시킴
			else k=0; //첫번째줄이 아닐때는 k의 값은 0
			for(int j=k;j<CAL_WIDTH;j++) { 
				if(num<=calLastDate) calDates[i][j] = num++;
			}
		}
	}
	
	
	//윤년인지 확인하는 함수
	private int leapCheck(int year) { 
		if(year%4==0 && year %100!=0||year%400==0) return 1;
		else return 0;
	}
	
	//현재 달로부터 n달 전, 후의 달력배열을 만드는 함수
	public void moveMonth(int mon) { 
		calMonth +=mon; 
		if(calMonth>11) { //12월일 때
			while(calMonth>11) {
				calYear++; //년도 +
				calMonth -=12; //월 -12
			}
		}else if(calMonth<0) { //1월일때 이전버튼을 누르면
			while(calMonth<0) {
				calYear--;
				calMonth +=12;
			}
		}
		cal = new GregorianCalendar(calYear,calMonth,calDayOfMon); //지정된 날짜로 캘린더 생성
		makeCalData(cal);
	}
}


public class MemoCalendar extends CalendarDataManager{ //GUI,메모, 시계기능이 있음
	
	JFrame mainFrame;
	
	JPanel calOpPanel; //달력 상위
		JButton today_bt; //오늘 날짜로 돌아오는 버튼
		JLabel today_lab; //오늘 날짜 출력
		JButton bYear_bt; //전년도 이동
		JButton bMon_bt; //전월로 이동
		JLabel curMY_lab; //오늘 날짜 출력
		JButton nMon_bt; //다음달로 이동
		JButton nYear_bt; //다음년도로 이동
		ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();
		
		
	JPanel calPanel; //달력
		JButton weekDaysName[]; //요일을 나타내는 버튼
		JButton date_bt[][] = new JButton[6][7]; //day를 나타내는 버튼
		//listenForDateButs lForDateButs = new listenForDateButs(); 
		
	//요일 배열
	final String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
		
		
	//Main
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MemoCalendar();
			}
		});
	}
	
	//생성자
	public MemoCalendar() {
		
		//메인프레임
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1020,680);
		mainFrame.setLocationRelativeTo(null); //윈도우창을 가운데로 띄우는 역할 
		
		//룩앤필이용해서 UI깔끔하게 
		try{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//LookAndFeel Windows 스타일 적용
			SwingUtilities.updateComponentTreeUI(mainFrame) ;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		//달력 상위 생성
		calOpPanel = new JPanel(); 
			today_bt = new JButton("Today");
			today_bt.addActionListener(lForCalOpButtons);
			today_lab = new JLabel(today.get(Calendar.MONTH)+1+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR));
			bYear_bt = new JButton("<<");
			bYear_bt.setToolTipText("Previous Year");
			bYear_bt.addActionListener(lForCalOpButtons);
			bMon_bt = new JButton("<");
			bMon_bt.setToolTipText("Previous Month");
			bMon_bt.addActionListener(lForCalOpButtons);
			curMY_lab = new JLabel("<html><table width=100><tr><th><font size=5>"+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "+calYear+"</th></tr></table></html>");
			nMon_bt = new JButton(">");
			nMon_bt.setToolTipText("Next Month");
			nMon_bt.addActionListener(lForCalOpButtons);
			nYear_bt = new JButton(">>");
			nYear_bt.setToolTipText("Next Year");
			nYear_bt.addActionListener(lForCalOpButtons);
			
			calOpPanel.setLayout(new GridBagLayout());
			GridBagConstraints calOpGC = new GridBagConstraints();
			calOpGC.gridx = 1; //좌표
			calOpGC.gridy = 1;
			calOpGC.gridwidth = 2; //그리드 상에서 수평축 수직축에 점유해야할 셀의 수 지정
			calOpGC.gridheight = 1;
			calOpGC.weightx = 1; //창 크기가 변해서 그리드의 크기가 변할 경우 컴포넌트 크기 변화 비율
			calOpGC.weighty = 1;
			calOpGC.insets = new Insets(5,5,0,0); //컴포넌트 외부 패팅
			calOpGC.anchor = GridBagConstraints.WEST; //사용가능한 공간보다 컴포넌트가 작을 경우 트리프트 될 방향 지정
			calOpGC.fill = GridBagConstraints.NONE; //컴포넌트보다 그리드 셀이 좀 더 넓을 경우 컴포넌트 사이즈를 리사이징
			calOpPanel.add(today_bt,calOpGC);
			calOpGC.gridwidth = 3;
			calOpGC.gridx = 2;
			calOpGC.gridy = 1;
			calOpPanel.add(today_lab,calOpGC);
			calOpGC.anchor = GridBagConstraints.CENTER;
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 1;
			calOpGC.gridy = 2;
			calOpPanel.add(bYear_bt,calOpGC);
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 2;
			calOpGC.gridy = 2;
			calOpPanel.add(bMon_bt,calOpGC);
			calOpGC.gridwidth = 2;
			calOpGC.gridx = 3;
			calOpGC.gridy = 2;
			calOpPanel.add(curMY_lab,calOpGC);
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 5;
			calOpGC.gridy = 2;
			calOpPanel.add(nMon_bt,calOpGC);
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 6;
			calOpGC.gridy = 2;
			calOpPanel.add(nYear_bt,calOpGC);
		
			
		//달력생성
		calPanel = new JPanel();
			weekDaysName = new JButton[7]; 
			//요일
			for(int i=0;i<CAL_WIDTH;i++) {
				weekDaysName[i] = new JButton(WEEK_DAY_NAME[i]);
				weekDaysName[i].setBorderPainted(false); //버튼의 외곽선 없애기
				weekDaysName[i].setContentAreaFilled(false); //내용영역 채우지 않음
				weekDaysName[i].setForeground(Color.WHITE); //글자색 변경
				if(i == 0) weekDaysName[i].setBackground(new Color(200, 50, 50)); //일요일
				else if (i == 6) weekDaysName[i].setBackground(new Color(50, 100, 200)); //토요일
				else weekDaysName[i].setBackground(new Color(150, 150, 150)); //평일
				weekDaysName[i].setOpaque(true); //불투명하게
				weekDaysName[i].setFocusPainted(false); //버튼 선택 했을 때 생기는 테두리 사용하지 않음
				calPanel.add(weekDaysName[i]); //패널에 버튼 조립
			}
			
			//date
			for(int i=0;i<CAL_HEIGHT;i++) {
				for(int j=0;j<CAL_WIDTH;j++) {
					date_bt[i][j] = new JButton();
					date_bt[i][j].setBorderPainted(false);
					date_bt[i][j].setContentAreaFilled(false);
					date_bt[i][j].setBackground(Color.WHITE);
					date_bt[i][j].setOpaque(true);
					//date_bt[i][j].addActionListener(lForDateButs);
					calPanel.add(date_bt[i][j]);
				}
			}
			calPanel.setLayout(new GridLayout(0,7,2,2));
			calPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
			showCal(); // 달력을 표시
			
	}
	
	
	//캘린더 보여주기
	private void showCal() {
		for(int i=0;i<CAL_HEIGHT;i++) {
			for(int j=0;j<CAL_WIDTH;j++) {
				//폰트 글씨 설정 
				String fontColor="black"; //평일
				if(j==0) fontColor="red"; //일요일
				else if(j==6) fontColor="blue"; //토요일
				
				JLabel todayMark = new JLabel("<html><font color=green>*</html>");
				
			}
		}
	}
	
	
	
	//달력상위부분의 버튼을 클릭했을 경우 수행됨
	private class ListenForCalOpButtons implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == today_bt) {
				setToday(); //오늘 날짜로 
			}
			else if(e.getSource() == bYear_bt) moveMonth(-12); //이전년도클릭했을 때 
			else if(e.getSource() == bMon_bt) moveMonth(-1); //이전 월 클릭했을 때
			else if(e.getSource() == nMon_bt) moveMonth(1); //다음 월 클릭했을 때
			else if(e.getSource() == nYear_bt) moveMonth(12); //다음년도 클릭했을 때

			curMY_lab.setText("<html><table width=100><tr><th><font size=5>"+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "+calYear+"</th></tr></table></html>");
			//showCal();
		}
	}
	
	
}






















