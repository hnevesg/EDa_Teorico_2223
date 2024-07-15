import java.util.Arrays;

public class Wagon {
	static int COL=4;	
	private int column;	
	private int ID;
	private int rows;
	private Seat seats[]; 
	private int occupied;
	
	Wagon(int id, int r) {
		column=COL;
		ID=id;
		rows=r;
		occupied=0;
		seats=new Seat [COL*r];
		for(int j=0;j<seats.length;j++) {
			seats[j]=new Seat();
		}
	} 
	
	public int occupiedSeats() {
		for (int i=0;i<seats.length;i++) {
			if (!seats[i].isFree())
				occupied++;
		}
		return occupied;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getRows() {
		return rows;
	}

	public Seat getSeat(int i) {
		return seats[i];
	}
	
	public Seat[] getSeatArr() {
		return seats;
	}

	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Wagon ID=" + ID + ", columns=" + column + ", rows=" + rows + ", seats=" + Arrays.toString(seats) + "\n";
	}
	
}