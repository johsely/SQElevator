package sqelevator;

// the abstraction interface to the IElevator
public interface IElevatorAdapter {
	public Elevator GetElevator(int elevatorNumber) throws java.rmi.RemoteException;
	
	/**
	 * Sets the committed direction of the specified elevator (up / down / uncommitted). 
	 * @param elevatorNumber elevator number whose committed direction is being set
	 * @param direction direction being set where up=0, down=1 and uncommitted=2
	 */
	public void setCommittedDirection(int elevatorNumber, int direction) throws java.rmi.RemoteException;

	/**
	 * Sets whether or not the specified elevator will service the specified floor (yes/no). 
	 * @param elevatorNumber elevator number whose service is being defined
	 * @param floor floor whose service by the specified elevator is being set
	 * @param service indicates whether the floor is serviced by the specified elevator (yes=true,no=false)
	 */
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws java.rmi.RemoteException; 

	/**
	 * Sets the floor target of the specified elevator. 
	 * @param elevatorNumber elevator number whose target floor is being set
	 * @param target floor number which the specified elevator is to target
	 */
	public void setTarget(int elevatorNumber, int target) throws java.rmi.RemoteException; 

	/**
	 * Retrieves the current clock tick of the elevator control system. 
	 * @return clock tick
	 */
	public long getClockTick() throws java.rmi.RemoteException;

	/**
	 * Retrieves the current data of the system. 
	 * @return a system
	 */
	public MySystem GetSystem() throws java.rmi.RemoteException;
}
