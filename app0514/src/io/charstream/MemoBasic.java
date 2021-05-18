package io.charstream;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//메모장 편집기의 기능 중 읽기 기능만을 구현해보자!!
public class MemoBasic extends JFrame implements ActionListener{
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JFileChooser chooser;
	
	public MemoBasic() {
		//생성
		bt = new JButton("Load");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		chooser = new JFileChooser("C:\\korea202102_javaworkspace\\app0514\\res");
		
		//스타일 및 레이아웃
		
		//조립
		add(bt,BorderLayout.NORTH);
		add(scroll);
		
		//리스너와 연결
		bt.addActionListener(this);
		
		//보여주기
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void openFileByte() { //다깨져버림 복사는 가능하지만 실시간으로 해석할 수는 없어 한글이 
		if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();//선택한 파일 정보 얻기
			System.out.println(file.getAbsolutePath());
			FileInputStream fis = null;
			//스트림을 생성(문자 해독 능력이 없음)
			try {
				fis = new FileInputStream(file.getAbsolutePath());
				//1byte씩 읽어서area에 출력
				int data = -1;
				while(true) {
					data = fis.read();//1byte 읽기	
					if(data ==-1)break;
					//System.out.println((char)data);
					area.append(Character.toString((char)data));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	public void openFileChar() {
		int res = chooser.showOpenDialog(this);
		if(res == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile(); //유저가 선택한 파일
			FileReader reader = null;
			try {
				reader = new FileReader(file.getAbsolutePath()); //문자 해석 능력이 있느 스트림
				int data =-1;
				while(true) {
					data = reader.read(); //read a character 문자를 읽음
					if(data==-1)break;
					area.append(Character.toString((char)data));
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(reader!=null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
//		openFileByte();
		openFileChar();
	}
	
	public static void main(String[] args) {
		new MemoBasic();
	}
}
