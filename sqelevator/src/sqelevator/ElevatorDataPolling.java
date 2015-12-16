package sqelevator;

import java.rmi.RemoteException;

public class ElevatorDataPolling {
	private IElevatorAdapter elevatorAdapter;
	public MySystem system; 
	public Elevator elevators[];
	
	
	public ElevatorDataPolling(IElevatorAdapter elevatorAdapter) {
		this.elevatorAdapter = elevatorAdapter;
		this.system = null;
		this.elevators = null;
	}
	
	// retrieves general information and creates array for elevators
	public void initialize(){
		try {
			system = elevatorAdapter.GetSystem();
			elevators = new Elevator[system.getElevatorNum()];
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// get the data from the elevatorAdapter
	public void getData() {
		try {
			system = elevatorAdapter.GetSystem(); // maybe split this in constant data and things that change
			for (int i = 0; i < system.getElevatorNum(); i++) {
				elevators[i] = elevatorAdapter.GetElevator(i);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
