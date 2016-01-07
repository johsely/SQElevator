package sqelevator;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

public abstract class ModeBase implements Observer{

	private IElevatorAdapter adapt;
	public Elevator elev;
	
	protected ModeBase( IElevatorAdapter adap) {
		adapt = adap;
		Elevator elev = new Elevator(0,3);	
	}
	
	
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException {
		adapt.setCommittedDirection(0, direction);
	}

	
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException {
		adapt.setServicesFloors(elevatorNumber, floor, service);	
	}

	
	public void setTarget(int elevatorNumber, int target) throws RemoteException {
		adapt.setTarget(elevatorNumber, target);
	}
	
	
	
}
