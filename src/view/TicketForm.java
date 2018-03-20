package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Flight;

public class TicketForm extends JPanel {
	
	//private List<Flight> flight;
	
	private JComboBox flightNum;
	private JTextField name, surname, seat, available;
	private JRadioButton local, inter;
	private ButtonGroup buttonGroup;
	
	private DefaultComboBoxModel flightModel;
	
	private String[] defaultFlight = {"Select flight..."};

	public TicketForm() {
		setLayout(new GridBagLayout());
		
		setPreferredSize(new Dimension(316, 316));
		
		//flight = new ArrayList<Flight>();
		
		flightNum = new JComboBox();
		
		flightModel = new DefaultComboBoxModel();
		
		name = new JTextField(5);
		surname = new JTextField(5);
		seat = new JTextField(5);
		available = new JTextField(5);
		
		buttonGroup = new ButtonGroup();
		local = new JRadioButton();
		inter = new JRadioButton();
		
		buttonGroup.add(local);
		buttonGroup.add(inter);
		
		available.setEditable(false);
		
		Border inner = BorderFactory.createTitledBorder("New Ticket");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outer, inner));
		
		layoutComponents();
	}
	
	public void updateFlight(List<Flight> flight) {
		for (int x = 0; x < flight.size(); x++) {
			flightModel.addElement(flight.get(x).getFlightNumber());
		}
		flightNum.setModel(flightModel);
	}
	
	public JComboBox getFlightComboBox() {
		return flightNum;
	}
	
	public void updateSeats(String seats) {
		available.setText(seats);
	}
	
	public JTextField getNameTF() {
		return name;
	}
	
	public JTextField getSurnameTF() {
		return surname;
	}
	
	public JTextField getSeatTF() {
		return seat;
	}
	
	public JTextField getAvailbleSeatsTF() {
		return available;
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
	
	public void layoutComponents() {
		GridBagConstraints gc = new GridBagConstraints();
		
		////// First Row //////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(new JLabel("Flight Number:"), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(flightNum, gc);		
		
		////// Next Row //////
		
		gc.gridx = 0;
		gc.gridy++;
					
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(new JLabel("Seats Available:"), gc);
						
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(available, gc);	
		
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
		add(new JLabel("First Name:"), gc);
					
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(name, gc);	
			
		////// Next Row //////
			
		gc.gridx = 0;
		gc.gridy++;
				
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(new JLabel("Last Name:"), gc);
					
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(surname, gc);	
		
		////// Next Row //////
		
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy++;
					
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5, 5, 100, 5);
		add(new JLabel("Number of Seats:"), gc);
						
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(5, 5, 100, 5);
		add(seat, gc);	
	}
	
}
