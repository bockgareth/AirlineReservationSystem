package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FlightForm extends JPanel {
	
	private JTextField num, seat;
	private JComboBox day, month, year, depart, arrive;
	private JRadioButton local, inter;
	private ButtonGroup buttonGroup;
	
	private DefaultComboBoxModel arriveModel;
	private DefaultComboBoxModel departModel;
	
	private int[] dayNum;
	private String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	private String[] years = {"2017", "2018", "2019", "2020", "2021"};
	
	private String[] defaultLoc = {"Select type..."};
	
	public FlightForm() {
		setLayout(new GridBagLayout());
		
		setPreferredSize(new Dimension(316,200));
		
		setBorder(BorderFactory.createEtchedBorder());
		
		dayNum = new int[31];
		
		for (int x = 0; x < 31; x++) {
			dayNum[x] = x + 1;
		}
		
		String[] days = Arrays.toString(dayNum).split("[\\[\\]]")[1].split(", "); 
		
		num = new JTextField(8);
		
		day = new JComboBox(days);
		month = new JComboBox(months);
		year = new JComboBox(years);
		
		arriveModel = new DefaultComboBoxModel();
		departModel = new DefaultComboBoxModel();
		
		buttonGroup = new ButtonGroup();
		local = new JRadioButton();
		inter = new JRadioButton();
		
		buttonGroup.add(local);
		buttonGroup.add(inter);
		
		
		
		
		
		depart  = new JComboBox(defaultLoc);
		depart.setPreferredSize(new Dimension(152, 25));
		arrive = new JComboBox(defaultLoc);
		arrive.setPreferredSize(new Dimension(152, 25));
		
		seat = new JTextField(8);
		
		Border inner = BorderFactory.createTitledBorder("New Flight");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outer, inner));
		
		layoutComponents();
		
	}
	
	
	public JComboBox getDepartComboBox() {
		return depart;
	}
	
	public JComboBox getArriveComboBox() {
		return arrive;
	}
	
	public void updateArrival(String[] locations) {
		for (String location: locations) {
			arriveModel.addElement(location);
		}
		arrive.setModel(arriveModel);
	}
	
	public void updateDeparture(String[] locations) {
		for (String location: locations) {
			departModel.addElement(location);
		}
		depart.setModel(departModel);
	}
	
	public JRadioButton getLocalButton() {
		return local;
	}
	
	public JRadioButton getInterButton() {
		return inter;
	}
	
	public JTextField getNumTF() {
		return num;
	}
	
	public JTextField getSeatTF() {
		return seat;
	}
	
	public JRadioButton getInterRButton() {
		return inter;
	}
	
	public JRadioButton getLocalRButton() {
		return local;
	}
	
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	
	public JComboBox getDayComboBox() {
		return day;
	}
	
	public JComboBox getMonthComboBox() {
		return month;
	}
	
	public JComboBox getYearComboBox() {
		return year;
	}
	
	
	
	public void layoutComponents() {
		GridBagConstraints gc = new GridBagConstraints();
		
		////// First Row //////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(20, 48, 5, 5);
		add(new JLabel("Flight Number:"), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(20, 5, 5, 5);
		add(num, gc);
		
		////// Next Row //////
			
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(new JLabel("Flight Date:"), gc);
			
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(day, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 53, 5, 5);
		add(month, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 100, 5, 5);
		add(year, gc);
		
		////// Next Row //////
		
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(new JLabel("Local (R500):"), gc);
					
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(local, gc);
			
		////// Next Row //////
			
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(new JLabel("International (R1000):"), gc);
					
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(inter, gc);
		
		////// Next Row //////
		
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(new JLabel("Depart from:"), gc);
				
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(depart, gc);
		
		////// Next Row //////
		
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(new JLabel("Arrive at:"), gc);
					
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(arrive, gc);
		
		////// Next Row //////
		
		gc.weightx = 1;
		gc.weighty = 0.7;
		
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(15, 5, 5, 5);
		add(new JLabel("Seats available:"), gc);
						
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(15, 5, 5, 5);
		add(seat, gc);
	}

}
