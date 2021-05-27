package app0526.thread.ex1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class CounterProgress extends JFrame{
	JLabel la;
	JProgressBar bar;
	JButton bt;
	JButton bt_man; //프로그래스바를 수동으로 증가시킬 버튼
	
	int count =0;
	int n = 0;
	
	Thread t1; //카운터를 증가시킬 쓰레드
	Thread t2; //프로그레스 바를 증가시킬 쓰레드
	boolean flag = true;
	
	public CounterProgress() {
		la = new JLabel(Integer.toString(count));
		bar = new JProgressBar();
		bt = new JButton("Start!");
		bt_man = new JButton("바 증가");
		
		//스타일 & 레이아웃
		this.setLayout(new FlowLayout());
		la.setFont(new Font("Verdana", Font.BOLD, 60));
		bar.setPreferredSize(new Dimension(260,40));
		
		//조립
		add(la);
		add(bar);
		add(bt);
		add(bt_man);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(1000,300,300,200);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCount();
			}
		});
		
		bt_man.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBar();
			}
		});
	}
	
	public void addCount() {
		t1 = new Thread() { //내부익명
			public void run() {
				while(true) {
					count++;
					la.setText(Integer.toString(count));
				}
			}
		};
		t1.start(); //JVM에게 맡기자!! 더이상 관여X
		System.out.println("카운터 증가");
	}
	
	public void addBar() {
		t2 = new Thread() {
			public void run() {
				while(flag) {
					n++;
					bar.setValue(n);
					if(n>90)flag=false;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
	}
	
	public static void main(String[] args) {
		new CounterProgress();
	}
}
