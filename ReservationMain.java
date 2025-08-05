package FinalProject;
import java.io.*;
import java.util.*;

public class ReservationMain  {

	public static void main(String[] args) throws Exception{
		Reservation reserves = new Reservation(0,null,null,0);
		int choice = -1;
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		File file = new File("RESERVATIONS.txt");

		//initializing an arraylist
		ArrayList<Reservation> list = new ArrayList <Reservation>();

		//object streams and list iterator
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null;

		if (file.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Reservation>)ois.readObject();
			ois.close();
		}

		do {
			int maxtables = 20;
			System.out.println("\n================================");
			System.out.println("VINNIES RESTAURANT\nTABLE BOOKING SYSTEM");
			System.out.println("================================");
			System.out.println("NUMBER OF RESERVATIONS: " + list.size());
			System.out.println("NUMBER OF TABLES LEFT TO RESERVE: " +(maxtables - list.size())+"/" +maxtables +"\n");
			System.out.println("1.ADD RESERVATION \n2.DISPLAY RESERVATIONS \n3.CANCEL RESERVATIONS  \n4.UPDATE A RECORD \n5.CANCEL ALL RESERVATIONS \n0.EXIT");
			choice = scan1.nextInt();

			switch(choice) {
			//TO INPUT RESERVATIONS
			case 1:
				boolean duplicated = false;
				System.out.println("Please Enter Details Below.....\n");
				System.out.print("Table Number: ");
				int table = scan1.nextInt();
				System.out.print("Customer Last Name: ");
				String lname = scan2.nextLine();
				System.out.print("Customer First Name: ");
				String fname = scan2.nextLine();
				System.out.print("Number of Seats: ");
				int seats = scan1.nextInt();
				duplicated = false;

				for(Reservation res : list) {
					if(res.getTable() == table) {
					System.out.println("---------------------------------"+
							"\n     TABLE ALREADY RESERVED"+
							"\n---------------------------------");
					duplicated = true;
					break;
					}
				if(table > maxtables) {
					System.out.println("---------------------------------" +
							"\n	RESERVATION FAILED"
							+"\n---------------------------------");
					duplicated = true;
					break;
					}
				if(seats > 7) {
					System.out.println("---------------------------------" +
							"\nMAXIMUM NUMBER OF SEATS EXCEEDED"
							+"\n---------------------------------");
					duplicated = true;
					break;
					}
				if(list.size() > 20) {
					System.out.println("---------------------------------"+
							"RESERVATION IS CLOSED!"+
							"\n---------------------------------");
					break;
				}
				}
				if(!duplicated) {
					list.add(new Reservation(table,lname,fname,seats));
					System.out.println("----------------------------------------------"+
							"\nCUSTOMER SUCCESSFULLY ADDED TO THE RESERVATION"+
							"\n----------------------------------------------");
				}
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(list);
				oos.close();
				break;

			//TO DISPLAY ALL RECORDS
			case 2:
				if(file.isFile()) {
				System.out.println("---------------------------------------------------------------------");
				System.out.println("DISPLAYING ALL RESERVATIONS...\n");
				System.out.println("TABLE NUMBER ||LAST NAME || FIRST NAME || SEATS ||");
				for (Reservation reserve : list) {
				System.out.println("     "+ reserve.getTable()+"  	  "+ reserve.getLname()+"          "+ reserve.getFname()+"        "+ reserve.getSeats());
				}
				System.out.println("---------------------------------------------------------------------");

				}else {
					System.out.println("File Does Not Exist!");
				}
			break;

			//TO DELETE A RECORD
			case 3:
			if(file.isFile()) {
				ois = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<Reservation>)ois.readObject();
				ois.close();

				boolean found = false;
				System.out.print("Enter Table Number to Delete: ");
				table = scan1.nextInt();
				System.out.println("--------------------------------------------");
				li = list.listIterator();
				while(li.hasNext()) {
					Reservation res = (Reservation)li.next();
					if(res.table == table) {
						li.remove();
						found = true;
					}
				}
				if(found) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(list);
					oos.close();
					System.out.println("RECORD SUCCESSFULLY DELETED");
				}
				else{
					System.out.println("RECORD NOT FOUND");
				}
				System.out.println("--------------------------------------------");
				}else {
					System.out.println("File Does Not Exist!");
				}
				break;

				//TO UPDATE A RECORD
				case 4:
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					list = (ArrayList<Reservation>)ois.readObject();
					ois.close();

				boolean found = false;
				System.out.print("Enter Table Number to Update: ");
				table = scan1.nextInt();
				System.out.println("--------------------------------------------");
				li = list.listIterator();
				while(li.hasNext()) {
					Reservation res = (Reservation)li.next();
					if(res.table == table) {
						System.out.println("Enter new Last Name: ");
						lname = scan2.nextLine();
						System.out.println("Enter new First Name: ");
						fname = scan2.nextLine();
						System.out.println("Enter new number of seats: ");
						seats = scan1.nextInt();
						li.set(new Reservation(table,lname,fname,seats));
						found = true;
					}
				}
				if(found) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(list);
					oos.close();
					System.out.println("---------------------------------"+
							"\nRECORD SUCCESSFULLY UPDATED"+
							"\n---------------------------------");
				}
				else{
					System.out.println("RECORD NOT FOUND");
				}
				System.out.println("--------------------------------------------");
				}else {
					System.out.println("File Does Not Exist!");
				}
				break;

				//TO CANCEL ALL RESERVATIONS
				case 5:
					if(file.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(file));
						list = (ArrayList<Reservation>)ois.readObject();
						ois.close();

						boolean found = false;
						li = list.listIterator();
						while(li.hasNext()) {
							Reservation resto = (Reservation)li.next();
							li.remove();
							found = true;
							}
						if(found) {
							oos = new ObjectOutputStream(new FileOutputStream(file));
							oos.writeObject(list);
							oos.close();
							System.out.println("---------------------------------"+
									"\nALL RECORDS SUCCESSFULLY DELETED"+
									"\n---------------------------------");
						}
						else{
							System.out.println("---------------------------------"
									+ "\n	RECORD NOT FOUND"+
									"\n---------------------------------");
						}
						}else {
							System.out.println("File Does Not Exist!");
						}
						break;
			}

		}while(choice!=0);
		System.out.println("THANK YOU FOR USING \nVINNIES RESTAURANT TABLE BOOKING SYSTEM");
	}

}

