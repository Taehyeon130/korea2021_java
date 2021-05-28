package app0528.json.test;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.json.simple.JSONObject;

public class JsonCountry extends JFrame{
	JPanel p_north;
	JButton bt;
	JTable table;
	JScrollPane scroll;
	Vector<JSONObject> data=new Vector<JSONObject>();
	Vector<String> column=new Vector<String>();
	String path = "https://gist.githubusercontent.com/keeguon/2310008/raw/bdc2ce1c1e3f28f9cab5b4393c7549f38361be4e/countries.json";
	
	public  JsonCountry() {
		column.add("Name");
		column.add("Code");
		
		p_north = new JPanel();
		bt = new JButton("Load From URL");
		table = new JTable(new AbstractTableModel() {
			public int getRowCount() {
				return data.size();
			}
			public int getColumnCount() {
				return column.size();
			}
			public String getColumnName(int col) {
				return column.get(col);
			}
			public Object getValueAt(int row, int col) {
				return null;
			}			
		});
		scroll = new JScrollPane(table);
		
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		setVisible(true);
		setBounds(1000, 100, 600, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JsonCountry();
	}

}