package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Flight;

public class TicketPanel extends JPanel {
	
	private List<Flight> flight;
	private DefaultComboBoxModel flightModel;
	private JComboBox flightNum;
	private JTextField available;
	
	private TicketForm form;
	private TicketTable table;
	
	public TicketPanel() {
		setLayout(new BorderLayout());
		
		form = new TicketForm();
		table = new TicketTable();
		
		flight = new ArrayList<Flight>();
		flightModel = new DefaultComboBoxModel();
		available = form.getAvailbleSeatsTF();
		flightNum = form.getFlightComboBox();
		
		add(form, BorderLayout.WEST);
		add(table, BorderLayout.EAST);
		
	}
	
	public void updateFlight(List<Flight> flight) {
		for (int x = 0; x < flight.size(); x++) {
			flightModel.addElement(flight.get(x).getFlightNumber());
		}
		flightNum.setModel(flightModel);
	}
	
	public void updateSeats(String seats) {
		form.updateSeats(seats);
	}
	
	public JTextField getNameTF() {
		return form.getNameTF();
	}
	
	public JTextField getSurnameTF() {
		return form.getSurnameTF();
	}
	
	public JTextField getSeatTF() {
		return form.getSeatTF();
	}
	
	public JRadioButton getInterRButton() {
		return form.getInterRButton();
	}
	
	public JRadioButton getLocalRButton() {
		return form.getLocalRButton();
	}
	
	public ButtonGroup getButtonGroup() {
		return form.getButtonGroup();
	}
	
	public JComboBox getFlightComboBox() {
		return form.getFlightComboBox();
	}
	
	public JTextField getAvailbleSeatsTF() {
		return form.getAvailbleSeatsTF();
	}
	
	public DefaultTableModel getTableModel() {
		return table.getTableModel();
	}
	
	public void filter(String query) {
		table.filter(query);
	}
	
	public void sort() {
		table.sort();
	}
	
	public void remove() {
		table.remove();
	}
	
	public JTable getTable() {
		return table.getTable();
	}

}
