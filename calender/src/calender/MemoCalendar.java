package calender;

import java.util.Calendar;

class CalenderDataManeger{
	//참조의 용도로만 사용됨
	static final int CAL_WIDTH = 7; //달력의 가로 
	static final int CAL_HEIGHT = 6; //달력의 세로
	int calDates[][] = new int[CAL_HEIGHT][CAL_WIDTH];
	int calYear; //년도
	int calMonth; //월
	int calDayOfMon; //일
	final int calLastDateOfMonth[]= {31,28,31,30,31,30,31,31,30,31,30,31}; //달의 마지막 일
	int calLastDate;
	Calendar today = Calendar.getInstance();
	Calendar cal;
	
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
	
	private void makeCalData(Calendar cal) {
		//1일의 위치와 마지막 날짜 구하기
		//DAY_OF_WEEK >> 요일을 구할수있음(월:1,화:2,수:3....)
		int calStartingPos = (cal.get(Calendar.DAY_OF_WEEK)+7-(cal.get(Calendar.DAY_OF_MONTH))%7)%7;
		
	}
}


public class MemoCalendar {
	
}
