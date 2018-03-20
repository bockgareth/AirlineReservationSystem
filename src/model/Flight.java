package model;

import java.util.Date;

public class Flight {
	
	private int flightNumber;
	private Date flightDate;
	private String type;
	private String departCity;
	private String arriveCity;
	private int seatsAvailable;
	private int seatsSold;
	private double seatPrice;
	private boolean cancelled;
	
	public Flight() {
	}
	
	public Flight(Date flightDate, String departCity, String arriveCity) {
		this.flightDate = flightDate;
		this.departCity = departCity;
		this.arriveCity = arriveCity;
	}
	
	public Flight(int flightNumber, Date flightDate, String type, String departCity, String arriveCity, int seatsAvailable) {
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.type = type;
		this.departCity = departCity;
		this.arriveCity = arriveCity;
		this.seatsAvailable = seatsAvailable;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}

	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public Date getFlightDate() {
		return flightDate;
	}
	
	public String getType() {
		return type;
	}

	public String getDepartCity() {
		return departCity;
	}

	public String getArriveCity() {
		return arriveCity;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public int getSeatsSold() {
		return seatsSold;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public String toString() {
		return "Flight flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", departCity=" + departCity
				+ ", arriveCity=" + arriveCity + ", seatsAvailable=" + seatsAvailable + ", seatsSold=" + seatsSold
				+ ", seatPrice=" + seatPrice + ", cancelled=" + cancelled;
	}
	
}
