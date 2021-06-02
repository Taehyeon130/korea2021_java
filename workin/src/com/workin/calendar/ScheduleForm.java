package com.workin.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ScheduleForm extends JDialog{
	String cate[] = {"회의","미팅","외근","휴가"};
	JPanel p_north;
	JComboBox<String> combo;
	JTextField title;
	JPanel p_center;
	JTextArea detail;
	JScrollPane scroll;
	JPanel p_south;
	JButton bt_regist;
	JButton bt_modify;
	JButton bt_del;
	
	public ScheduleForm(JFrame frame,String top) {
		super(frame,top);

		//생성
		p_north = new JPanel();
		combo = new JComboBox<String>(cate);
		title = new JTextField();
		p_center = new JPanel();
		detail = new JTextArea(26,80);
		scroll = new  JScrollPane(detail);
		p_south = new JPanel();
		bt_regist = new JButton("등록");
		bt_modify = new JButton("수정");
		bt_del = new JButton("삭제");
		
		//스타일

		combo.setPreferredSize(new Dimension(130,30));
		title.setPreferredSize(new Dimension(530,30));
		
		Border lineBorder = BorderFactory.createLineBorder(Color.black,1);
		detail.setBorder(lineBorder);
		//조립
		p_north.add(combo);
		p_north.add(title);
		add(p_north,BorderLayout.NORTH);
		p_center.add(scroll);
		add(p_center);
		p_south.add(bt_regist);
		p_south.add(bt_modify);
		p_south.add(bt_del);
		add(p_south,BorderLayout.SOUTH);
		
		//보여주기
		setSize(750,600);
		
	}
	
}
