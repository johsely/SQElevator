package sqelevator.tests;


import java.rmi.RemoteException;
import java.util.Observable;

import sqelevator.Elevator;
import sqelevator.IElevatorAdapter;

public class DummyElevatorDataPolling extends Observable implements Runnable {
	private IElevatorAdapter elevatorAdapter;

	public  Elevator elevators[];

	
	
	public DummyElevatorDataPolling(IElevatorAdapter elevatorAdapter) {
		this.elevatorAdapter = elevatorAdapter;
	} 
	
	public void run() {
		initialize();
		while(true){
			runDataPolling();
		}
	}
	
	public Elevator GetElevator() {
		return elevators[0]; // FIXME: only 1 elevator supported now
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
		setChanged();
	    notifyObservers();
		
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}




