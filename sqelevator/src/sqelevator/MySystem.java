package sqelevator;

public class MySystem {
	private boolean floorButtonsDown[];
	private boolean floorButtonsUp[];
	private int floorHeight;
	private int floorNum;
	private int elevatorNum;
	
	
	public MySystem(int floorHeight, int floorNum, int elevatorNum) {
		this.floorHeight = floorHeight;
		this.floorNum = floorNum;
		this.elevatorNum = elevatorNum;
		this.floorButtonsDown = new boolean[floorNum];
		this.floorButtonsUp = new boolean[floorNum];
	}
	
	public int getElevatorNum(){
		return elevatorNum;
	}
	
	public int getFloorNum(){
		return floorNum;
	}
	
	public int getFloorHeight(){
		return floorHeight;
	}
	
	public void setFloorButtonDown(int floor, boolean pressed) {
		assert(floor >= 0 && floor < floorNum);
		floorButtonsDown[floor] = pressed;
	}
	
	public boolean getFloorButtonDown(int floor) {
		assert(floor >= 0 && floor < floorNum);
		return floorButtonsDown[floor];
	}
	
	public void setFloorButtonUp(int floor, boolean pressed) {
		assert(floor >= 0 && floor < floorNum);
		floorButtonsUp[floor] = pressed;
	}
	
	public boolean getFloorButtonUp(int floor) {
		assert(floor >= 0 && floor < floorNum);
		return floorButtonsUp[floor];
	}
		
}
