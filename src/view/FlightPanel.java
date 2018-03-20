package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FlightPanel extends JPanel {
	
	private FlightForm form;
	private FlightTable table;

	
	public FlightPanel() {
		setLayout(new BorderLayout());

		form = new FlightForm();
		table = new FlightTable();
		
		
		add(form, BorderLayout.WEST);
		add(table, BorderLayout.CENTER);
		
		
	}
	
	public JComboBox getDepartComboBox() {
		return form.getDepartComboBox();
	}
	
	public JComboBox getArriveComboBox() {
		return form.getArriveComboBox();
	}
	
	public JRadioButton getLocalButton() {
		return form.getLocalButton();
	}
	
	public JRadioButton getInterButton() {
		return form.getInterButton();
	}
	
	public void updateArrival(String[] location) {
		form.updateArrival(location);
	}
	
	public void updateDeparture(String[] location) {
		form.updateDeparture(location);
	}
	
	public JTextField getNumTF() {
		return form.getNumTF();
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
	
	public JComboBox getDayComboBox() {
		return form.getDayComboBox();
	}
	
	public JComboBox getMonthComboBox() {
		return form.getMonthComboBox();
	}
	
	public JComboBox getYearComboBox() {
		return form.getYearComboBox();
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
