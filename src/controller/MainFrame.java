package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import model.Flight;
import model.Ticket;
import view.Console;
import view.FlightPanel;
import view.TicketPanel;
import view.Toolbar;

public class MainFrame extends JFrame {
	
	private List<Flight> flight;
	private List<Ticket> ticket;
	private List<String> cancelledFlights;
	private List<String> cancelledTickets;
	
	private static final double LOCAL_PRICE = 500;
	private static final double INTER_PRICE = 1000;
	
	private String[] localDestinations = {"Cape Town", "Johannesburg", "Durban", "Port Elizabeth", "George"};
	private String[] interDestinations = {"Sydney", "London", "New York", "Paris", "Amsterdam"};
	private String[] interDeparts = {"Cape Town", "Johannesburg"};
	
	private SimpleDateFormat dt, dt1;
	private Date date;
	private static double amountPaid;
	private boolean alreadyExecuted = false;
	
	private Toolbar toolbar;
	private JTabbedPane tab;
	private FlightPanel flightPanel;
	private TicketPanel ticketPanel;
	private Console console;
	
	private static double interSales = 0;
	private static double localSales = 0;
	
	
	
	public MainFrame() {
		super("Airline Reservation System");
		
		setLayout(new BorderLayout());
		
		setJMenuBar(createMenuBar());
		
		flight = new ArrayList<Flight>();
		ticket = new ArrayList<Ticket>();
		cancelledFlights = new ArrayList<String>();
		cancelledTickets = new ArrayList<String>();
		
		dt = new SimpleDateFormat("dd-MM-yyyy");
		dt1 = new SimpleDateFormat("dd-MM-yyyy");
		date = new Date();
		
		toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
		
		flightPanel = new FlightPanel();
		ticketPanel = new TicketPanel();
	
		tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.BOTTOM);
		tab.add("Flight", flightPanel);
		tab.add("Ticket", ticketPanel);
		
		add(tab, BorderLayout.CENTER);

		console = new Console();
		add(console, BorderLayout.SOUTH);
		
		Arrays.sort(localDestinations);
		Arrays.sort(interDestinations);
		
		flightPanel.getLocalButton().setActionCommand("Local");
		flightPanel.getInterButton().setActionCommand("International");
		
		ticketPanel.getLocalRButton().setActionCommand("Local");
		ticketPanel.getInterRButton().setActionCommand("International");
		
		flightPanel.getLocalButton().addActionListener(new ButtonHandler());
		flightPanel.getInterButton().addActionListener(new ButtonHandler());

		toolbar.getLogButton().addActionListener(new ButtonHandler());
		toolbar.getRelButton().addActionListener(new ButtonHandler());
		
		toolbar.getSearchTF().addKeyListener(new KeyHandler());
		
		flightPanel.sort();
		ticketPanel.sort();
		
		ticketPanel.getFlightComboBox().addItemListener(new ItemHandler());
		
		setSize(935, 550);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static boolean isNum(String strNum) {
	    boolean ret = true;
	    try {
	        Integer.parseInt(strNum);
	    }catch (NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		
		JMenu tool = new JMenu("Tools");
		JMenu help = new JMenu("Help");
		
		JMenuItem cancelFlight = new JMenuItem("Cancelled flights");
		JMenuItem cancelTicket = new JMenuItem("Cancelled tickets");
		JMenuItem report = new JMenuItem("Sales report");
		JMenuItem exit = new JMenuItem("Exit");
		
		JMenuItem about = new JMenuItem("About");
		JMenuItem guide = new JMenuItem("Guide");
		
		JMenuItem update = new JMenuItem("Check for updates");
		
		update.setPreferredSize(new Dimension(175, 20));
		tool.add(update);
		
		about.setPreferredSize(new Dimension(175, 20));
		help.add(guide);
		help.addSeparator();
		help.add(about);
		
		cancelFlight.setPreferredSize(new Dimension(175, 20));
		file.add(cancelFlight);
		file.add(cancelTicket);
		file.add(report);
		file.addSeparator();
		file.add(exit);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		cancelFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String list = Arrays.toString(cancelledFlights.toArray()).replace("[", "").replace("]", "").replace(",", "");
				JOptionPane.showMessageDialog(null, list);
			}
		});
		
		cancelTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String list = Arrays.toString(cancelledTickets.toArray()).replace("[", "").replace("]", "").replace(",", "");
				JOptionPane.showMessageDialog(null, list);
			}
		});
		
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("About");
				setLayout(new BorderLayout());
				frame.setSize(300, 250);
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame.setResizable(false);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
				JTextArea area = new JTextArea(3, 3);
				frame.add(area, BorderLayout.CENTER);
				area.setEditable(false);
				String version = "\n\n       Airline Reservation System\n\n       Version: Available Release(1.1)\n\n       "
						+ "Build id: 000214084-410\n\n       (c) Copyright Airline Reservation Systems\n       contributors and others 2000, 2017.\n       All rights reserved.";
				area.setText(version);
			}
		});
		
		guide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Guide");
				setLayout(new BorderLayout());
				JLabel l1 = new JLabel();
				//C:\\Users\\Gareth\\Pictures\\Guidefinal.png
				
				l1.setIcon(new ImageIcon("C:\\Users\\logda\\Desktop\\Guidefinal.png"));
				frame.add(l1, BorderLayout.CENTER);
				
				validate();
				frame.setSize(1050, 670);
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame.setResizable(false);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "No updates available");
			}
		});
		
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int x = 0; x < ticket.size(); x++) {
					if (ticket.get(x).getType() == "International") {
						interSales += ticket.get(x).getAmountPaid();
					} else if (ticket.get(x).getType() == "Local") {
						localSales += ticket.get(x).getAmountPaid();
					}
				
				}
				JOptionPane.showMessageDialog(null, "International Sales: " + interSales + "\nLocal Sales: " + localSales);
			}
		});
		
		menuBar.add(file);
		
		menuBar.add(tool);
		menuBar.add(help);
		
		return menuBar;
	}
	
	private class ButtonHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == flightPanel.getLocalButton()) {
				flightPanel.getDepartComboBox().removeAllItems();
				flightPanel.updateDeparture(localDestinations);
				flightPanel.getArriveComboBox().removeAllItems();
				flightPanel.updateArrival(localDestinations);
			}
			
			if (e.getSource() == flightPanel.getInterButton()) {
				flightPanel.getDepartComboBox().removeAllItems();
				flightPanel.updateDeparture(interDeparts);
				flightPanel.getArriveComboBox().removeAllItems();
				flightPanel.updateArrival(interDestinations);
			}
			
			if (e.getSource() == toolbar.getLogButton()) {
				
				console.getConsole().setText(" ");
				if (toolbar.getTypeComboBox().getSelectedIndex() == 0) {
					
					if (!isNum(flightPanel.getNumTF().getText()) || flightPanel.getNumTF().getText().isEmpty()) {
						
						console.getConsole().setText("Error 034: Null/Invalid option for flight number.");
						
					} else if(!flightPanel.getInterButton().isSelected() && !flightPanel.getLocalButton().isSelected()) {
						
						console.getConsole().setText("Error 00x9: Null/Invalid option for local or international selection.");
						
					} else if (!isNum(flightPanel.getSeatTF().getText()) || flightPanel.getSeatTF().getText().isEmpty()) {
						
						console.getConsole().setText("Error 035: Null/Invalid option for seat number.");
						
					} else {
						
						String date_s = flightPanel.getDayComboBox().getSelectedItem()  + "-" + flightPanel.getMonthComboBox().getSelectedItem() + 
								"-" + flightPanel.getYearComboBox().getSelectedItem();
					
						try {
							date = dt.parse(date_s);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						
						flight.add(new Flight(Integer.parseInt(flightPanel.getNumTF().getText()), date, flightPanel.getButtonGroup().getSelection().getActionCommand().toString(),
								flightPanel.getDepartComboBox().getSelectedItem().toString(), flightPanel.getArriveComboBox().getSelectedItem().toString(), 
								Integer.parseInt(flightPanel.getSeatTF().getText())));
						
						flightPanel.getTableModel().addRow(new Object[]{Integer.parseInt(flightPanel.getNumTF().getText()), dt1.format(date), 
								flightPanel.getButtonGroup().getSelection().getActionCommand().toString(), flightPanel.getDepartComboBox().getSelectedItem().toString(),
								flightPanel.getArriveComboBox().getSelectedItem(), Integer.parseInt(flightPanel.getSeatTF().getText())});
						
						ticketPanel.getFlightComboBox().removeAllItems();
						ticketPanel.updateFlight(flight);
						
						if(!alreadyExecuted) {
							ticketPanel.updateSeats(flightPanel.getSeatTF().getText());
						    alreadyExecuted = true;
						}
						
						
						flightPanel.getNumTF().setText(null);
						flightPanel.getButtonGroup().clearSelection();
						flightPanel.getSeatTF().setText(null);
						
					}
					
					for (int x = 0; x < flight.size(); x++) {
						if (flight.get(x).getType() == "Local") {
							flight.get(x).setSeatPrice(LOCAL_PRICE);
						} else if (flight.get(x).getType() == "International"){
							flight.get(x).setSeatPrice(INTER_PRICE);
						}
					}

				} else if (toolbar.getTypeComboBox().getSelectedIndex() == 1) {
						
					if (isNum(ticketPanel.getNameTF().getText()) || ticketPanel.getNameTF().getText().isEmpty()) {
							
						console.getConsole().setText("Error 061: Null/Invalid option for first name.");
							
					} else if(isNum(ticketPanel.getSurnameTF().getText()) || ticketPanel.getSurnameTF().getText().isEmpty()) {
							
						console.getConsole().setText("Error 062: Null/Invalid option for last name.");
							
					} else if(!ticketPanel.getInterRButton().isSelected() && !ticketPanel.getLocalRButton().isSelected()) {
						
						console.getConsole().setText("Error 00x9: Null/Invalid option for local or international selection.");
						
					} else if (!isNum(ticketPanel.getSeatTF().getText()) || ticketPanel.getSeatTF().getText().isEmpty()) {
							
						console.getConsole().setText("Error 063: Null/Invalid option for number of seats.");
							
					} else {
						amountPaid = 0;
						for (int x = 0; x < flight.size(); x++) {
							amountPaid = Integer.parseInt(ticketPanel.getSeatTF().getText()) * flight.get(x).getSeatPrice();
						}
						
						if (Integer.parseInt(ticketPanel.getAvailbleSeatsTF().getText()) > 0) {
							ticket.add(new Ticket(Integer.parseInt(ticketPanel.getFlightComboBox().getSelectedItem().toString()), 
									ticketPanel.getSurnameTF().getText(), Integer.parseInt(ticketPanel.getSeatTF().getText()), amountPaid, ticketPanel.getButtonGroup().getSelection().getActionCommand().toString()));
							
							
							
							ticketPanel.updateSeats(Integer.toString((Integer.parseInt(ticketPanel.getAvailbleSeatsTF().getText()) - Integer.parseInt(ticketPanel.getSeatTF().getText()))));
							
							for (int x = 0; x < flight.size(); x++) {
								if (ticketPanel.getFlightComboBox().getSelectedItem().toString().equals(Integer.toString(flight.get(x).getFlightNumber()))) {
									flight.get(x).setSeatsAvailable(Integer.parseInt(ticketPanel.getAvailbleSeatsTF().getText()) - Integer.parseInt(ticketPanel.getSeatTF().getText() ));
								}
							}
						
							ticketPanel.getTableModel().addRow(new Object[] {ticketPanel.getFlightComboBox().getSelectedItem().toString(), ticketPanel.getButtonGroup().getSelection().getActionCommand().toString(),
									ticketPanel.getSurnameTF().getText(), ticketPanel.getNameTF().getText(), Integer.parseInt(ticketPanel.getSeatTF().getText()), amountPaid});
								
							ticketPanel.getNameTF().setText(null);
							ticketPanel.getSurnameTF().setText(null);
							ticketPanel.getSeatTF().setText(null);
							
						} else {
							
							JOptionPane.showMessageDialog(null, "Not enough seats");
							
						}
					}
					
				}
				
			}
			
			if (toolbar.getTypeComboBox().getSelectedIndex() == 0) {
				if (e.getSource() == toolbar.getRelButton()) {
					int column = 0;
					int row = flightPanel.getTable().getSelectedRow();
					String value = flightPanel.getTable().getModel().getValueAt(row, column).toString();
					int value_s = Integer.parseInt(value);
					//System.out.println(value);
					for (int x = 0; x < flight.size(); x++) {
						if (flight.get(x).getFlightNumber() == value_s) {
							flight.get(x).setCancelled(true);
							String cancel = "Flight Number: " + flight.get(x).getFlightNumber() + " Departing from " + flight.get(x).getDepartCity() + " to " + flight.get(x).getArriveCity() + ".  Status: Cancelled\n\n";
							
							cancelledFlights.add(cancel);
							ticketPanel.getFlightComboBox().removeAllItems();
							ticketPanel.updateFlight(flight);
						}
					}
					flightPanel.remove();
					
				}
			}
			
			if (toolbar.getTypeComboBox().getSelectedIndex() == 1) {
				if (e.getSource() == toolbar.getRelButton()) {
					int column = 0;
					int row = ticketPanel.getTable().getSelectedRow();
					String value = ticketPanel.getTable().getModel().getValueAt(row, column).toString();
					int value_s = Integer.parseInt(value);
					//System.out.println(value);
					for (int x = 0; x < flight.size(); x++) {
						if (flight.get(x).getFlightNumber() == value_s) {
							
							String cancel = "Flight Number: " + flight.get(x).getFlightNumber() + " " + ticket.get(x).getPassengerSurname() + ", decline their ticket(s)\n\n";
							
							cancelledTickets.add(cancel);
							
						}
					}
					String val1 = ticketPanel.getTable().getModel().getValueAt(row, 4).toString();
					int val_1 = Integer.parseInt(val1);
					ticketPanel.remove();
					
					
					ticketPanel.updateSeats(Integer.toString((Integer.parseInt(ticketPanel.getAvailbleSeatsTF().getText()) + val_1)));
					
					
				}
			}
		}
	}
	
	private class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			String query = toolbar.getSearchTF().getText();
			flightPanel.filter(query);
			ticketPanel.filter(query);
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}
		
	}
	
	private class ItemHandler implements ItemListener {
		
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				
				for (int x = 0; x < flight.size(); x++) {
					if (ticketPanel.getFlightComboBox().getSelectedItem().toString().equals(Integer.toString(flight.get(x).getFlightNumber()))) {
						ticketPanel.updateSeats(Integer.toString(flight.get(x).getSeatsAvailable()));
					}
				}
			}
		}
		
	}

}
