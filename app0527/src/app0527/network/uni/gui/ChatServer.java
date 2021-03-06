package app0527.network.uni.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * EchoServer의 단점
 * 멀티유저를 허용하지 못한다 
 * */

public class ChatServer extends JFrame implements ActionListener{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	
	ServerSocket server; //접속을 감지하는 소켓
	Thread thread; //접속자 감지를 처리하기 위한 쓰레드, 쓰레드가 없다면 메인쓰레드가 대기상태에 빠진다
	
	public ChatServer() {
		//생성
		p_north = new JPanel();
		t_port = new JTextField(10);
		bt = new JButton("서버가동");
		area = new JTextArea();
		scroll= new JScrollPane(area);
		
		//스타일 & 레이아웃
		
		//조립
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		//이벤트
		bt.addActionListener(this);
		
		//뷰
		setVisible(true);
		setBounds(1000,600,400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//서버 가동
	public void startServer() {
		int port = Integer.parseInt(t_port.getText());
		BufferedReader buffr =null; //버퍼처리된 문자기반의 입력 스트림
		BufferedWriter buffw = null; //버퍼터리된 문자기반의 출력스트림
		
		try {
			server = new ServerSocket(port);
			area.append("서버 생성\n접속자 기다리는 중\n");
			
			while(true) {
			//접속자 감지 후 대화용 쓰레드 반환받기
			Socket socket= server.accept(); //이 코드에 의해 접속자가 발견될때까지 실행부는 무한 대기에 빠지게된다
								   //특히 무한대기에 빠지게 될 실행부가 메인쓰레드라면, 메인쓰레드의 고유 업무인 이벤트처리,gui처리 등을 할 수가 없다
								   //따라서 프로그램이 먹통된다!!
			
			InetAddress addr = socket.getInetAddress();
			String ip = addr.getHostAddress();
			area.append(ip+" 님 접속 감지!\n");
			
			
			
			//곧 사라질 Socket을 얼른 ServerMsgThread의 인스턴스로 보관해 놓자
			ServerMsgThread msgThread = new ServerMsgThread(socket,area);
			msgThread.start(); // 각각 알아서 움직여라!
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		thread = new Thread() {
			//개발자는 쓰레드로 처리하고픈 로직을 run에 작성한다!!
			public void run() {
				startServer();				
			}
		};	
		thread.start(); 
	}

	public static void main(String[] args) {
		new ChatServer();

	}

}
