package db.table.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;



/*JTable이 사용할 데이터를 TableModel을 이용해서 좀 더 유지보수성에 있어서 개선을 해보자
 * TableModel?
 * - JTable과 같은 디자인 영역에서 실제 데이터를 직접 접근하지 말고 중간에 계층을 두고 데이터의 조회, 입력, 수정등을 이 중간 계층을 통해 작업을 진행하면 
 * 		추후 JTable이 변경될때 데이터를 처리하려는 로직은 영향을 받지 않게 되므로 어플리케이션의 유지보수성을 높일 수 있다
 * - JTable이 사용하려는 데이터를 간접적으로 사용할 수있게 도와주는 컨트롤러를 의미*/

public class UseModelApp extends JFrame{

	JTable table;
	JScrollPane scroll;
	JTextArea area; //선택한 회원의 상세정보 출력할 영역
	
	JPanel p_west;
	JTextField t_user_id;
	JPasswordField t_password;
	JTextField t_name;
	JButton bt_regist;
	JButton bt_del;
	
	String[] columnName= {"member_id","user_id","password","name","regdate"};
	String[][] rows= {};

	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user = "root";
	String password="1234";
	Connection con;
	UseModelApp uma = this;
	
	String value; //현재는 null이다. 따라서 한번도 레코드를 선택하지 않았다면, 여전히 null로 남아있을 것이다.
	
	int row; //현재 사용자가 JTable을 마우스로 선택한 레코드
	
	public UseModelApp() {
		table = new JTable(new AbstractTableModel() {
			
			//총 레코드 수 반환하는 메서드 그리고 이 메서드는 JTable이 호출하는 것이다!!
			public int getRowCount() {
				return rows.length;
			}
			//총 컬럼 수를 반환하는 메서드 이 메서드도 JTable이 호출
			public int getColumnCount() {
				return columnName.length;
			}
			
			public String getColumnName(int col) { //col변수 호출시마다 1씩 증가시키며 호출 
				return columnName[col];
			}
			
			//row,col좌표에 어떤 데이터가 있는지 반환하는 메서드, 이 또한 JTable이 호출하는 것
			//즉 TableModel의 모든 메서드가 JTable을 위한 것이다
			public Object getValueAt(int row, int col) {
//				System.out.println("getValueAt("+row+","+col+")"); //자동증가 하는것을 알 수 있음
				return rows[row][col];
			}
			
		});
		//테이블 모델 객체 이용가능
		
		scroll = new JScrollPane(table);
		area = new JTextArea();
		
		//서쪽 등록 폼
		p_west = new JPanel();
		t_user_id = new JTextField(15);
		t_password = new JPasswordField(15);
		t_name = new JTextField(15);
		bt_regist = new JButton("등록");
		bt_del = new JButton("삭제");
		
		
		//테이블에 클릭이벤트 구현
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				//area.append("클릭\n");
				row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				value = (String)table.getValueAt(row, col);
				//area.setText("선택한 위치는"+row+","+col+"그리고 값은 "+value);
				
				area.setText(""); //출력전에 초기화
				
				area.append("member_id : "+table.getValueAt(row, 0)+"\n");
				area.append("아이디 : " + table.getValueAt(row, 1)+"\n");
				area.append("비밀번호 : "+table.getValueAt(row, 2) +"\n");
				area.append("이름 : "+table.getValueAt(row, 3) +"\n");
				area.append("가입일 : "+table.getValueAt(row, 4) +"\n");
			}
		});
		
		//스타일 
		scroll.setPreferredSize(new Dimension(600,400));
		area.setPreferredSize(new Dimension(600,150));
		p_west.setPreferredSize(new Dimension(200,400));
		
		p_west.add(t_user_id);
		p_west.add(t_password);
		p_west.add(t_name);
		p_west.add(bt_regist);
		p_west.add(bt_del);
		
		add(scroll);
		add(area,BorderLayout.SOUTH);
		add(p_west,BorderLayout.WEST);
		
		//등록버튼과 리스너 연결
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
			}
		});
		
		//삭제버튼과 리스너 연결
		//내부익명클래스 내부이기 때문에 그냥 this를 하게 되면 내부익명을 가리키게 된다.
		bt_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1번째 방법 - 변수를 하나 선언하여 Frame의 인스턴스 주소값을 넣기
				//JOptionPane.showConfirmDialog(uma,"삭제하시겠습니까?");
				//2번째 방법
				if(value!=null) {
					int res = JOptionPane.showConfirmDialog(UseModelApp.this,"삭제하시겠습니까?");			
					if(res ==JOptionPane.OK_OPTION) {
						del();
					}
				}else {
					JOptionPane.showMessageDialog(UseModelApp.this,"삭제하실 회원을 선택하세요");
				}
			}
		});
		
		
		//윈도우와 리스너 연결
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(0);
			}
		});
		setBounds(1100,200,800,400);
		setVisible(true);
		connect();
	}
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //드라이버 로드
			con = DriverManager.getConnection(url,user,password); //접속
			if(con==null) {
				JOptionPane.showMessageDialog(this,"MySQL접속 실패");
			}else {
				getList();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select *from member";
		
		try {
			pstmt = con.prepareStatement(sql
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_READ_ONLY);
			
			rs= pstmt.executeQuery(); //레코드 담기
			rs.last(); //커서를 마지막 레코드로 이동
			int total = rs.getRow();
			
			String[][] data = new String[total][columnName.length]; //empty상태의 이차원 배열을 생성
			//주의할 점) 스크롤 가능한 옵션을 줘야하고, 커서의 위치에 주의하자
			rs.beforeFirst(); //커서를 다시 처음 위치로
			int index =0;
			
			while(rs.next()) {
				data[index][0] = Integer.toString(rs.getInt("member_id"));
				data[index][1] = rs.getString("user_id");
				data[index][2] = rs.getString("password");
				data[index][3] = rs.getString("name");
				data[index][4] = rs.getString("regdate");
				index++;
			}
			
			//rs를 이차원배열로 바꾼다!!
			rows=data;
			
			table.updateUI(); //디자인 갱신
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//등록
	public void regist() {
		PreparedStatement pstmt = null;
		
		String sql ="insert into member(user_id,password,name) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t_user_id.getText());
			pstmt.setString(2, new String(t_password.getPassword()));
			pstmt.setString(3, t_name.getText());
			
			int result = pstmt.executeUpdate(); //이 DML실행에 의해 영향을 받은 레코드 수를 반환함
			//땨라선 insert의 경우 제대로 수행되었다면 1이 반환되어야함
			if(result==1) {
				JOptionPane.showMessageDialog(this, "등록성공");
				getList();
			}else {
				JOptionPane.showMessageDialog(this, "등록실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!= null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	} 
	
	//삭제
	public void del() {
		PreparedStatement pstmt = null;
		//아래의 경우는 unBoxing의 예이다
		int member_id =Integer.parseInt((String)table.getValueAt(row, 0)); //삭제할 레코드의 pk를 받을 변수
		
		String sql = "delete from member where member_id="+member_id;
//		System.out.println(sql);
		
		try {
			pstmt = con.prepareStatement(sql);
			int result = pstmt.executeUpdate(); //삭제 실행!!
			if(result>0) {
				JOptionPane.showMessageDialog(this, "삭제완료");
				getList(); //갱신
			}else {
				JOptionPane.showMessageDialog(this, "삭제실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new UseModelApp();

	}


}
