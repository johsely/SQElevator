package sqelevator;

import java.rmi.server.RemoteObject;

public class Elevator {
	/**
	 * 
	 */
	

	public Elevator(int nrOfFloors) {
		this.setNrOfFloors(nrOfFloors); 
		target = 0;
		servicesFloors = new boolean[nrOfFloors];
	}
	
	public Elevator() {
		// TODO Auto-generated constructor stub
		nrOfFloors = 0;
	}

	public int getNrOfFloors() {
		return nrOfFloors;
	}

	public void setNrOfFloors(int nrOfFloors) {
		this.nrOfFloors = nrOfFloors;
	}

	private int nrOfFloors;

	private int target;
	private boolean[] servicesFloors;
	private int committedDirection;

	public int getCommittedDirection()
	{
		return committedDirection;
	}

	public int getElevatorAccel()
	{
		return 0;
	}

	public boolean getElevatorButton(int floor)
	{
		return false;
	}

	public int getElevatorDoorStatus()
	{
		return IElevator.ELEVATOR_DOORS_OPEN;
	}

	public int getElevatorFloor()
	{
		return target;
	}

	public int getElevatorPosition()
	{
		return 0;
	}

	public int getElevatorSpeed()
	{
		return 0;
	}

	public int getElevatorWeight()
	{
		return 0;
	}

	public int getElevatorCapacity()
	{
		return 0;
	}

	public boolean getServicesFloors(int floor)
	{
		return servicesFloors[floor];
	}

	public int getTarget()
	{
		return target;
	}

	public void setCommittedDirection(int direction)
	{
		committedDirection = direction;
	}

	public void setServicesFloors(int floor, boolean service)
	{
		servicesFloors[floor] = service;
	}

	public void setTarget(int target)
	{
		this.target = target;
	}
	
}
