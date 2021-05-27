package app0526.threadex2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressEx extends JFrame{
	JProgressBar bar1;
	JProgressBar bar2;
	JProgressBar bar3;
	JButton bt;
	
	Thread t1;
	Thread t2;
	Thread t3;
	
	int n=0;
	
	
	public ProgressEx() {
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
		bt = new JButton("Start");
		
		this.setLayout(new FlowLayout());
		bar1.setPreferredSize(new Dimension(200,40));
		bar2.setPreferredSize(new Dimension(200,40));
		bar3.setPreferredSize(new Dimension(200,40));

		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(1000,300,220,300);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBar(t1,bar1,10);
				addBar(t2,bar2,100);
				addBar(t3,bar3,1000);
			}
		});
	}
	
	public void addBar(Thread t,JProgressBar b,int h) {
		t = new Thread() {
			public void run() {
				while(true) {
					n++;
					b.setValue(n);
					try {
						Thread.sleep(h);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
	


	public static void main(String[] args) {
		new ProgressEx();
	}
}

