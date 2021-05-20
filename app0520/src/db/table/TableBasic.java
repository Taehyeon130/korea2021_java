package db.table;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.PreparedStatement;

//DBMS 등의 표 형식(2차원구조)의 데이터를 표현하는데 최적화된 JTable을 이용해본다

public class TableBasic extends JFrame{
	//JTable의 생성자 중 레코드는 이차원 배열로 지원하고 컬럼의 제목은 일차원 배열로 지원하는 3번째 생성자를 이용해보자
	String[] columns= {"member_id","user_id","password","name","regdate"};
	String[][] rows= {}; //생성되지도 않음 - 자바에서 배열은 객체 따라서 rows는 레퍼런스 변수가 된다.
									//아직 DB 연동 전이므로 배열의 크기를 알 수 없기 때문에 
	
	JTable table;
	JScrollPane scroll;
	
	//mysql 접속 문자열에 사용될 접속 정보
	String url = "jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user = "root";
	String password = "1234";
	Connection con; //접속 후 그 정보를 가진 객체 
	
	public TableBasic() {
		connect(); //JTable이 사용할  이차원 배열을 먼저 구해야하므로 위에 놓는다
		
		table = new JTable(rows,columns); //rows,columns
		scroll = new JScrollPane(table);
		
		add(scroll);
		
		setBounds(1100,200,500,250);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { //내부익명 클래스 
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
	}
	
	//데이터베이스 가져오기
	public void connect() {
		/*
		 * 1.드라이버 로그
		 * 2. 접속
		 * 3. 쿼리수행
		 * 4. 자원해제
		 */
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(this, "MySQL 드라이버 로드 성공");
			con = DriverManager.getConnection(url,user,password);
			if(con!=null) {
				JOptionPane.showMessageDialog(this,"접속성공");
				select();
			}else {
				JOptionPane.showMessageDialog(this,"접속실패");
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "드라이버 로드 실패\n드라이버를 찾을 수 없습니다");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//select 문을 수행하는 메서드 정의
	public void select() {
		String sql = "select *from member";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt =con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//위의 옵션을 줄 경우 스크롤 가능하면서 읽기 전용의 ResultSet을 생성할 수 있다.
			
			rs = pstmt.executeQuery(); //쿼리 수행 및 레코드 반환
			
			//rs의 데이터를 이차원 배열로 변환하여 JTable에게 적용시켜보자!!
			//rs에는 총 레코드 수를 반환해주는 메서드가 별도로 지원되지 않는다!! 따라서 개발자가 다음의 절차를 거켜 총 레코드 수를 구할 수 있다
			//1) 커서를 레코드의 제일 마지막으로 이동! last()
			//2) 마지막으로 이동된 커서의 row 넘버를 구한다. 여기서 넘버란 몇번째 레코드인지에 대한 순번이다
			//    만일 rowNum이 3이라면 3번째 데이터라는 의미이다
			rs.last();
			int num = rs.getRow(); //현재의 레코드 순번을 반환받는다
			System.out.println("현재위치"+num);
			
			String[][] data = new String[num][columns.length];
			
			rs.beforeFirst();//last에 가 있는 rs의 커서를 다시 처음으로 원상복귀시키자
			int index = 0;
			while(rs.next()) { //커서 한칸 전진
				//rs의 레코드에 접근하여, empty상태에 있는 2차원 배열로 데이터를 옮겨보자!!
				data[index][0] = Integer.toString(rs.getInt("member_id")); //int 형을 String 객체형으로 변환!! 이때 사용되는 객체가 바로 Wrapper
				data[index][1] = rs.getString("user_id"); 
				data[index][2] = rs.getString("password"); 
				data[index][3] = rs.getString("name"); 
				data[index][4] = rs.getString("regdate"); 
				index++;
			}
			rows = data; //JTable이 참조할 예정인 rows의 주소값을 data 이차원배열로 대체해버리자!!

		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TableBasic(); 
	}
}
