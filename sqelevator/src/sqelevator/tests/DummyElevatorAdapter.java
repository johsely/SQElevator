package sqelevator.tests;

import java.rmi.RemoteException;

import sqelevator.Elevator;
import sqelevator.IElevatorAdapter;
import sqelevator.MySystem;

// dummy
public class DummyElevatorAdapter implements IElevatorAdapter {
	private Elevator dummyElevator;
	private MySystem dummySystem;
	
	public DummyElevatorAdapter() {
		dummyElevator = new Elevator(3);
		dummySystem = new MySystem(5, 3, 1);
	}
	
	@Override
	public Elevator GetElevator(int elevatorNumber) throws RemoteException {
		return dummyElevator;
	}

	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException {
		dummyElevator.setCommittedDirection(direction);
	}

	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException {
		dummyElevator.setServicesFloors(floor, service);
	}

	@Override
	public void setTarget(int elevatorNumber, int target) throws RemoteException {
		dummyElevator.setTarget(target);
	}

	@Override
	public long getClockTick() throws RemoteException {
		return 100;
	}

	@Override
	public MySystem GetSystem() throws RemoteException {
		return dummySystem;
	}

}
