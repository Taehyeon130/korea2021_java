package app0528.network.multi.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	ServerSocket server;//클라이언트의 접속을 감지하는 소켓(대화용 X)
	
	/*쓰레드 구현의 3가지 방법
	 * 1. 별도의 .java파일로 생성(재사용성 높을 때 , 관리목적 상 코드를 분리시키고 싶을 때)
	 * 2. 내부익명
	 * 3. Runnable 인터페이스 구현
	 * */
	Thread serverThread; //메인메서드 대신 서버의 접속자 감지를 위한 무한대기를 처리할 쓰레드
	Vector<ServerMsgThread> clientList; //접속자가 발생했을 때 이 접속자와 통신을 하게 될 ServerMsgThread의 인스턴스를 담게될 벡터
							//이 벡터를 통해 접속자의 수, ServerMsgThread의 주소값을 이용한 제어 등이 가능
	
	
	public ChatServer() {
		//생성
		p_north = new JPanel();
		t_port = new JTextField(10);
		bt = new JButton("서버가동");
		area = new JTextArea();
		scroll= new JScrollPane(area);
		clientList = new Vector<ServerMsgThread>();
		//스타일 & 레이아웃
		
		//조립
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		
		//이벤트
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverThread = new Thread() {
					public void run() {
						startServer();
					}
				};
				serverThread.start(); //Runnable로 진입
			}
		});
		
		
		//뷰
		setVisible(true);
		setBounds(1200,600,300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public void startServer() {
		int port = Integer.parseInt(t_port.getText()); //포트 구하기
		try {
			server = new ServerSocket(port);
			area.append("서버 가동 및 접속자 감지중...\n");
			while(true) {
				Socket socket = server.accept(); //접속자 감지를 위한 대기!!(메인 쓰레드를 절대로 이용하지 말자)
				String ip = socket.getInetAddress().getHostAddress();
				area.append(ip+" 님  접속감지\n");
					
				ServerMsgThread msgThread = new ServerMsgThread(socket,this); //대화용 쓰레드 생성 
				msgThread.start(); //대화용 쓰레드 동작 시작!! (Runnable로 진입시킴)
				clientList.add(msgThread); //접속자 명단에 추가하기
				area.append("현재 접속자 "+clientList.size()+"명\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
