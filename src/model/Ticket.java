package model;

public class Ticket {

	private int ticketNumber;
	private int flightNumber;
	private String passengerName;
	private String passengerSurname;
	private int seatsBooks;
	private double amountPaid;
	private String type;
	
	public Ticket() {
	}
	
	public Ticket(int flightNumber, String passengerSurname, int seatsBooks, double amountPaid, String type) {
		this.flightNumber = flightNumber;
		this.passengerSurname = passengerSurname;
		this.seatsBooks = seatsBooks;
		this.amountPaid = amountPaid;
		this.type = type;
	}
	

	public String getType() {
		return type;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public void setPassengerSurname(String passengerSurname) {
		this.passengerSurname = passengerSurname;
	}

	public void setSeatsBooks(int seatsBooks) {
		this.seatsBooks = seatsBooks;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public String getPassengerSurname() {
		return passengerSurname;
	}

	public int getSeatsBooks() {
		return seatsBooks;
	}

	public double getAmountPaid() {
		return amountPaid;
	}
	

	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", flightNumber=" + flightNumber + ", passengerName="
				+ passengerName + ", passengerSurname=" + passengerSurname + ", seatsBooks=" + seatsBooks
				+ ", amountPaid=" + amountPaid + "]";
	}
	
}
