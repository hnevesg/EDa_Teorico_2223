
public class Seat {
	private boolean free;
	private String occupant;

	Seat() {
		free=true;
		occupant=null;
	}
	
	public void setFree(boolean free) {
		this.free = free;
	}

	public String getOccupant() {
		return occupant;
	}

	public void setOccupant(String occupant) {
		this.occupant = occupant;
	}

	public boolean isFree() {
		return free;
	}

	@Override
	public String toString() {
		return occupant==null? ""+free : free + ", passenger ID: " + occupant;
	}  
	
	
}
