package app0528.network.multi.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerMsgThread extends Thread{
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	ChatServer chatServer;
	boolean flag = true; //현재 쓰레드를 동작제어할 수 있는 논리값 즉 false로 두는 순간, 이 쓰레드는dead상태
	
	public ServerMsgThread(Socket socket,ChatServer chatServer) {
		this.socket = socket;
		this.chatServer = chatServer;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void listen() {
		String msg = null;
		try {
			msg = buffr.readLine(); //클라이언트가 모낸 메시지 듣기
			//서버에 접속한 모든 유저의 send메서드 호출
			for(int i=0;i<chatServer.clientList.size();i++) {
				ServerMsgThread msgThread = chatServer.clientList.get(i); //벡터의 각 요소에 들어있는 쓰레드 꺼내기!!
				msgThread.send(msg); //다시 클라이언트에게 보내기
			}
			chatServer.area.append(msg+"\n");//서버의 로그에 남기기
		} catch (IOException e) {
			e.printStackTrace();
			//대화 목록 수에서 제거!!
			chatServer.clientList.remove(this);
			chatServer.area.append("클라이언트 나갔음, 현재 접속자 "+chatServer.clientList.size()+"명\n");
			flag = false;
		}
	}
	
	public void send(String msg) {
		//버퍼 처리된 스트림에서의 문자열의 끝을 표시할때는 줄바꿈
		try {
			buffw.write(msg+"\n"); 
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(flag) {
			listen();
		}
	}
}
