import java.util.Arrays;
import java.util.Scanner;

public class Train implements ITrain{
	static Scanner sc=new Scanner(System.in);
	private Wagon w[];
	private boolean fulltrain;
	int i=0;
	
	Train(int r) {
		w=new Wagon[MAXWAGONS];
		int rows=r;
		w[0]=new Wagon(1, rows);
		fulltrain=false;
	} 
	
	public int addWagon(int rows) { 
		try {
			i++;
			w[i] = new Wagon(i+1,rows);
		}catch(ArrayIndexOutOfBoundsException n) {
			// it "ignores" it because in the TrainsApp is checked
		}
		return i;
	}

	public boolean trainFull() {
		return fulltrain;
	}

	public void setFullTrain(boolean f) {
		fulltrain=f;
	}

	public Wagon getWagon(int i) {
		return w[i];
	}
	
	public int getTotalWagons() {
		int counter=0;
		for(int i=0;i<w.length;i++) {
			if(w[i]!=null) {
				counter++;
			}
		}
		return counter;
	}

	public int numPassengers() {
		int passengers=0;
		String s="";
		String actual_passenger;
		for(int i=0;i<getTotalWagons();i++) {
			for(int j=0;j<getWagon(i).getRows()*4;j++) {
				actual_passenger=getWagon(i).getSeat(j).getOccupant();
				if(actual_passenger!=null && !actual_passenger.equals(s)) {
					passengers++;
					s=actual_passenger;
				}
			}
		}
		return passengers;
	}
	
	public String toString() {
		return "Train wagons: \n" + Arrays.toString(w) + "\nThe total number of passengers is "+ numPassengers();
	}
}