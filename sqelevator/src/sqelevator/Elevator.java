package sqelevator;

import java.rmi.server.RemoteObject;

public class Elevator {
	/**
	 * 
	 */
	
	private int nrOfFloors;


	private boolean[] servicesFloors;
	private boolean[] requestButtons;
	private boolean floorButtonsDown[];
	private boolean floorButtonsUp[];
	
	private int committedDirection;
	private int doorStatus;
	
	private int target;
	private int position; // current position in feet from ground
	private int closestFloor; // current closest floor
	private int acceleration;
	private int speed;
	private int floorHeight;
	private int elevatorNum;
	private int weight;
	
	
	public Elevator(int elevatorNum, int nrOfFloors) {
				
		if (elevatorNum  < 0) throw new RuntimeException("Minimum Elevator Num is 0!");


		this.elevatorNum = elevatorNum;
		
		if (nrOfFloors  < 2) throw new RuntimeException("Minimum Floors is 2!");
		
		this.nrOfFloors  = nrOfFloors;
		
		this.floorHeight = 0;
		servicesFloors = new boolean[nrOfFloors];
		requestButtons = new boolean[nrOfFloors];
		this.floorButtonsDown = new boolean[nrOfFloors];
		this.floorButtonsUp = new boolean[nrOfFloors];

		committedDirection = 0;
		doorStatus = 0;
		
		target = 0;
		setPosition(0);
		closestFloor = 0;
		acceleration = 0;
		speed = 0;
		
		weight = 0;
	}

	public int getNrOfFloors() {
		return nrOfFloors;
	}

	public int getCommittedDirection()
	{
		return committedDirection;
	}
	
	public void setCommittedDirection(int direction){
		committedDirection = direction;
	}

	public boolean getElevatorButton(int floor)
	{
		assert(floor < nrOfFloors && floor >= 0);
		return requestButtons[floor];
	}

	public int getElevatorDoorStatus()
	{
		return doorStatus;
	}
	
	public void setElevatorDoorStatus(int status){
		doorStatus = status;
	}

	public int getElevatorPosition()
	{
		return position;
	}

	public int getElevatorSpeed()
	{
		return speed;
	}
	
	public void setElevatorSpeed(int speed) {
		this.speed = speed;
	}

	public int getElevatorWeight()
	{
		return weight;
	}

	public boolean getServicesFloors(int floor)
	{
		return servicesFloors[floor];
	}

	public int getTarget()
	{
		return target;
	}


	public void setTarget(int target)
	{
		this.target = target;
	}
	
	public void setServicesFloors(boolean floors[]){
		servicesFloors = floors;
	}
	
	public void setServicesFloors(int floor, boolean service)
	{
		servicesFloors[floor] = service;
	}

	public int getElevatorAcceleration() {
		return acceleration;
	}

	public void setElevatorAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public boolean[] getRequestButtons() {
		return requestButtons;
	}

	public void setRequestButtons(boolean[] requestButtons) {
		this.requestButtons = requestButtons;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getClosestFloor() {
		return closestFloor;
	}

	public void setClosestFloor(int closestFloor) {
		this.closestFloor = closestFloor;
	}
	
	public void setFloorButtonDown(int floor, boolean pressed) {
		assert(floor >= 0 && floor < nrOfFloors);
		floorButtonsDown[floor] = pressed;
	}
	
	public boolean getFloorButtonDown(int floor) {
		assert(floor >= 0 && floor < nrOfFloors);
		return floorButtonsDown[floor];
	}
	
	public void setFloorButtonUp(int floor, boolean pressed) {
		assert(floor >= 0 && floor < nrOfFloors);
		floorButtonsUp[floor] = pressed;
	}
	
	public boolean getFloorButtonUp(int floor) {
		assert(floor >= 0 && floor < nrOfFloors);
		return floorButtonsUp[floor];
	}
	
	
	public int getElevatorNum(){
		return elevatorNum;
	}
	
	
	public int getFloorHeight(){
		return floorHeight;
	}
	
	
	public void setNrofFloors(int nrOfFloors){
		
		if (nrOfFloors  < 2) throw new RuntimeException("Minimum Floors is 2!");
		this.nrOfFloors  = nrOfFloors;
	}
	
	public void setFloorHeight(int floorHeight){
		this.floorHeight =  floorHeight;
	}
	
}
