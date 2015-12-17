package sqelevator;

import java.rmi.RemoteException;

public class ElevatorDataPolling {
	private IElevatorAdapter elevatorAdapter;

	public  Elevator elevators[];

	
	
	public ElevatorDataPolling(IElevatorAdapter elevatorAdapter) {
		this.elevatorAdapter = elevatorAdapter;
		
	}
	
	// retrieves general information and creates array for elevators
	public void initialize(){
		try {

			elevators = new Elevator[elevatorAdapter.getElevatorCnt()];
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// get the data from the elevatorAdapter
	public void runDataPolling() {
		try {

			for (int i = 0; i < elevatorAdapter.getElevatorCnt(); i++) {
				elevators[i] = elevatorAdapter.GetElevator(i);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
