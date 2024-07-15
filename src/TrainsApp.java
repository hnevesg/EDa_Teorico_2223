/**********************************************************************
* Class Name: TrainsApp
* Class description: This program simulates an app to book tickets of a train.
* 
***********************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainsApp {
	static Scanner sc=new Scanner(System.in);
	static int MAXWAGONS=4;
	
	public static void main(String[]args) {
		menu();
	}
	
	/**********************************************************************
	* Method name: createTrain
	*
	* Description of the Method: The method creates a train
	*
	* Calling arguments: none
	* 					
	* Return value: Train, the created train
	* 
	*********************************************************************/
	public static Train createTrain() {
		System.out.println("A new train is going to be created: ");
		int rows=askRows();
		Train t = new Train(rows);
		return t;
	}
	
	/**********************************************************************
	* Method name: askRows
	*
	* Description of the Method: The method asks to the user for the number of rows of the train
	*
	* Calling arguments: none
	* 					
	* Return value: int, the answer of the user
	* 
	*********************************************************************/
	public static int askRows() {
		int rows=0;
		System.out.println("Please introduce the total number of rows of each wagon of the train");
		rows=checkSeats_Rows();
		return rows;
	}
	
	/**********************************************************************
	* Method name: seatReservation
	*
	* Description of the Method: The method makes the reservation of the asked seats by the user
	*
	* Calling arguments: Train t, the already created train
	* 					
	* Return value: void
	* 
	*********************************************************************/
	public static  void seatReservation(Train t){ 
		if(t==null) {
			System.out.println("The train has not been created yet.");
		}else {
		
			String passenger=askID();
			int asked_seats=askSeats();
			int currentWagon=t.getTotalWagons()-1;
			int current_seat=0; // variable used as index for changing to occupied the seats
			int free_seats=0; // variable for remaining seats when no more wagons can be created
			boolean full; // boolean for when no more wagons can be created
					
			int available_seats=t.getWagon(currentWagon).getSeatArr().length - t.getWagon(currentWagon).occupiedSeats();
		
			
			if(available_seats<=0) {
				t.setFullTrain(true);
				System.out.println("Sorry, the train is full.");
				
			}else if(asked_seats>available_seats) {
				do {
					full = currentWagon+1>MAXWAGONS?true:false;
					if(full) {
						System.out.println("Sorry, there are not enough available seats. And no wagon can be created.\nJust " + free_seats + " seats booked");
						break;
					}else{
						try {
							while(!t.getWagon(currentWagon).getSeat(current_seat).isFree()) {
								current_seat++;
							}
							t.getWagon(currentWagon).getSeat(current_seat).setFree(false);
							t.getWagon(currentWagon).getSeat(current_seat).setOccupant(passenger);
							current_seat++;
							asked_seats--;
							free_seats++;
						
						}catch(ArrayIndexOutOfBoundsException m) {
							System.out.println("Not enough seats in this Wagon, adding a new one...");
							currentWagon=t.addWagon(t.getWagon(0).getRows());
							current_seat=0;
							continue;	
						}
					}
				}while(asked_seats!=0);
				if(!full) 
				System.out.println("Seats successfully booked!");
				
			}else {
				do{
				while(!t.getWagon(currentWagon).getSeat(current_seat).isFree()) {
					current_seat++;
				}
				t.getWagon(currentWagon).getSeat(current_seat).setFree(false);
				t.getWagon(currentWagon).getSeat(current_seat).setOccupant(passenger);
				current_seat++;
				asked_seats--;
				}while(asked_seats!=0);
				System.out.println("Seats successfully booked!");
			}
		}
	} 
	
	/**********************************************************************
	* Method name: showTrain
	*
	* Description of the Method: The method shows by screen all information regarding the train
	*
	* Calling arguments: Train t, the already created train
	* 					
	* Return value: void
	* 
	*********************************************************************/
	public static void showTrain(Train t) {
		if(t!=null) {
			System.out.println(t.toString());
		}else {
			System.out.println("The train has not been created yet.");
		}
	}
	
	/**********************************************************************
	* Method name: askID
	*
	* Description of the Method: The method asks to the user for its ID
	*
	* Calling arguments: none
	* 					
	* Return value: String, the answer of the user
	* 
	*********************************************************************/
	public static String askID() {
		System.out.println("Please introduce your ID");
		String s = sc.next().toLowerCase(); //toLowerCase(), to avoid being case sensitive
		return s;
	}
	
	/**********************************************************************
	* Method name: checkSeats_Rows
	*
	* Description of the Method: The method checks if the value introduced by
	* 							 keyboard is bigger than 0
	*
	* Calling arguments: none
	* 					
	* Return value: int, the valid number introduced by the user
	* 
	*********************************************************************/
	public static int checkSeats_Rows(){
		int number=0;
		boolean b=true;
		do{	
			try {
				number = sc.nextInt();
				if(number<=0) throw new IndexOutOfBoundsException();
					b=false;
				}
				catch(InputMismatchException y){ 
					System.out.println("Error, letters and symbols are not allowed. Try again:");
					sc.next();
				}
				catch(IndexOutOfBoundsException z) {
					System.out.println("Error, the number must be greater than 0. Try again:");
				}
		}while(b);
		
	return number;
	}
	
	/**********************************************************************
	* Method name: askSeats
	*
	* Description of the Method: The method asks to the user for the number of seats to book
	*
	* Calling arguments: none
	* 					
	* Return value: int, the answer of the user
	* 
	*********************************************************************/
	public static int askSeats() {
		int seats=0;
		System.out.println("Please introduce the numbers of seats to buy");
		seats=checkSeats_Rows();
		return seats;
	}
	
	/**********************************************************************
	* Method name: showOptions
	*
	* Description of the Method: The method shows by screen the possible options that the user can choose
	*
	* Calling arguments: none
	* 					
	* Return value: void
	* 
	*********************************************************************/
	public static void showOptions() {
		System.out.println("Select one of the following options. If you want to exit, write 4.");
		System.out.println("1.Create a train");
		System.out.println("2.Buy tickets");
		System.out.println("3.Show train");
		System.out.println("4.Exit");
	}
	
	/**********************************************************************
	* Method name: menu
	*
	* Description of the Method: The method shows the menu to the user, and according to the answer it executes one method or another
	*
	* Calling arguments: 
	* 					
	* Return value: void
	* 
	*********************************************************************/
	public static void menu() {
		int option=0;
		Train t=null;
		do {
		showOptions();
		option=checkAnswer();
		 			
		// Each option has a method in charge of executing to get the expected results
		switch (option) {
		case 1: 
			t=createTrain();
			break;
		case 2:
			seatReservation(t);
			break;
		case 3: 
			showTrain(t);
			break;
		case 4:
			System.out.print("End of the program.");
			break;
		}
		System.out.println(" ");
		}while(option > 0 && option < 4);
	}
	
	/**********************************************************************
	* Method name: checkAnswer
	*
	* Description of the Method: The method checks if the value introduced by
	* 							 keyboard is valid according to the possible options
	*
	* Calling arguments: none
	* 					
	* Return value: int, the valid number introduced by the user
	* 
	*********************************************************************/
	public static int checkAnswer() {
		boolean result=false;
		int option=0;
		do {
		try {
			//We ask for a number in range [0,4], which is the number of options in the menu
				option=sc.nextInt();
				if(option<=0 || option>=5) throw new IndexOutOfBoundsException();
				result=false;
			}
			catch(InputMismatchException y){ 
				System.out.println("Error, letters and symbols are not allowed. Try again:");
				sc.next();
				result=true;
			}
			catch(IndexOutOfBoundsException z) {
				System.out.println("Error, the number must be in the range [1,4]. Try again:");
				result=true;
			}
		}while(result);
		
	return option;
	}
}
