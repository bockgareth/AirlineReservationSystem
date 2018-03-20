package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Console extends JPanel{
	
	private JTextField console;
	
	public Console() {
		setLayout(new BorderLayout());
		
		console = new JTextField(50);
		console.setFont(new Font("default", Font.BOLD, 12));
		console.setEditable(false);
		console.setBorder(BorderFactory.createEmptyBorder());
		
		setBorder(BorderFactory.createEtchedBorder());
		
		setPreferredSize(new Dimension(0, 35));
		
		add(console, BorderLayout.WEST);
	}
	
	public JTextField getConsole() {
		return console;
	}

}
