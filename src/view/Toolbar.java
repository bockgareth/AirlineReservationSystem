package view;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Toolbar extends JPanel {
	
	private JComboBox type;
	private JButton log, relieve;
	private JTextField search;
	
	private String[] port = {"Flight", "Ticket"};
	
	public Toolbar() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		type = new JComboBox(port);
		
		log = new JButton("Log to file");
		search = new JTextField(10);
		
		relieve = new JButton("Relieve");
		
		
		add(new JLabel("COM Port: "));
		add(type);
		add(relieve);
		add(log);
		add(new JLabel("      Search:"));
		add(search);
		
		validate();
		
	}
	
	public JButton getLogButton() {
		return log;
	}
	
	public JButton getRelButton() {
		return relieve;
	}
	
	public JComboBox getTypeComboBox() {
		return type;
	}
	
	public JTextField getSearchTF() {
		return search; 
	}
	
	
}
