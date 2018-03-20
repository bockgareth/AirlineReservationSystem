package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TicketTable extends JPanel {
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	
	private String[] columnName = {"Flight Number", "Type","Last Name", "First Name", "Seats Booked", "Price (R)"};
	
	public TicketTable() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		setPreferredSize(new Dimension(600, 200));
		
		tableModel = new DefaultTableModel(columnName, 0);
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(595, 390));
		add(scroll);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		for (int x = 0; x < 6; x++) {
			table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
		}
	}
	
	public void filter(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
	
	public void sort() {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(sorter);
	}
	
	public void remove() {
		tableModel.removeRow(table.getSelectedRow());
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	public JTable getTable() {
		return table;
	}

}
