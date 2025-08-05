package FinalProject;
import java.io.*;

public class Reservation implements Serializable{
	//attributes
		int table;
		String lname;
		String fname;
		int seats;



	//constructors
		public Reservation(int table, String lname, String fname, int seats) {
			this.table = table;
			this.lname = lname;
			this.fname = fname;
			this.seats = seats;


		}

		//getters and setters
		public int getTable() {
			return table;
		}
		public void setTable(int table) {
			this.table = table;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public int getSeats() {
			return seats;
		}
		public void setSeats(int seats) {
			this.seats = seats;
		}


	public String toString() {
		return table+" "+lname+" "+fname+" "+seats;
	}
	}
