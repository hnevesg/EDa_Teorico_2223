
public interface ITrain {
	/**********************************************************************
	* This interface defines the functionality of a train
	*********************************************************************/
	
	static int MAXWAGONS=4;  // total wagons in a train

	/**********************************************************************
 	* Method name: addWagon
	*
	* Description of the Method: The method adds a wagon to the train
	*
	* Calling arguments: int rows, the total rows of every wagon
	* 					
	* Return value: int
	**********************************************************************/
	public int addWagon(int rows);
	
	/**********************************************************************
 	* Method name: getTotalWagons
	*
	* Description of the Method: The method returns the number of wagons that are currently being used
	*
	* Calling arguments: none
	* 					
	* Return value: int
	**********************************************************************/
	public int getTotalWagons();
	
	/**********************************************************************
 	* Method name: trainFull
	*
	* Description of the Method: The method returns whether the train is full or not
	*
	* Calling arguments: none
	* 					
	* Return value: boolean
	**********************************************************************/
	public boolean trainFull();

	/**********************************************************************
 	* Method name: setFullTrain
	*
	* Description of the Method: The method changes the full attribute of the train
	*
	* Calling arguments: boolean f, the new value
	* 					
	* Return value: void
	**********************************************************************/
	public void setFullTrain(boolean f);

	/**********************************************************************
 	* Method name: getWagon
	*
	* Description of the Method: The method returns the wagon that corresponds to the index
	*
	* Calling arguments: int i, the index of the corresponding wagon
	* 					
	* Return value: Wagon
	**********************************************************************/
	public Wagon getWagon(int i);
	
	/**********************************************************************
 	* Method name: numPassengers
	*
	* Description of the Method: The method returns the total number of passengers
	*
	* Calling arguments: none
	* 					
	* Return value: int
	**********************************************************************/
	public int numPassengers();
}
