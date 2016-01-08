package sqelevator.tests;

import java.rmi.RemoteException;

import sqelevator.Elevator;
import sqelevator.IElevatorAdapter;
import sqelevator.IElevator;

// this dummy tries to simulate simple elevator behavior
public class DummyElevatorAdapter2 implements IElevatorAdapter  {
	private Elevator dummyElevator;
	private int elevatorCnt;
	
	public DummyElevatorAdapter2(int elevatorNum, int elevatorCnt, int ElevatorWeight, int nrOfFloors ) {
		dummyElevator = new Elevator(elevatorNum, nrOfFloors );
		this.elevatorCnt = elevatorCnt;
		
		dummyElevator.setCommittedDirection(0);
		dummyElevator.setElevatorAcceleration(0);
		
		boolean requestButtons[] = new boolean[nrOfFloors];
		boolean servicesFloor[] = new boolean[nrOfFloors];

		for (int i = 0; i < nrOfFloors; i++) {
			requestButtons[i] = true;
			servicesFloor[i] = true;
			dummyElevator.setFloorButtonDown(i, true);
			dummyElevator.setFloorButtonUp(i, true);

		}
		dummyElevator.setRequestButtons(requestButtons);
		dummyElevator.setServicesFloors(servicesFloor);
		
		
		dummyElevator.setElevatorDoorStatus(2);
		dummyElevator.setClosestFloor(0);
		dummyElevator.setPosition(0);
		dummyElevator.setElevatorSpeed(0);
		dummyElevator.setWeight(ElevatorWeight);
		dummyElevator.setTarget(0);
		dummyElevator.setNrofFloors(nrOfFloors);	
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
		int currentClosestFloor = dummyElevator.getClosestFloor();
		int currentPos = dummyElevator.getPosition();
		int committedDir = 0;
		
		dummyElevator.setTarget(target);
		dummyElevator.setElevatorAcceleration(1);
		dummyElevator.setElevatorSpeed(1);
		dummyElevator.setClosestFloor(target);
		
		if ((target - currentClosestFloor) > 0) {
			committedDir = IElevator.ELEVATOR_DIRECTION_UP;
		}
		else {
			committedDir = IElevator.ELEVATOR_DIRECTION_DOWN;
		}
		dummyElevator.setCommittedDirection(committedDir);
		dummyElevator.setElevatorDoorStatus(IElevator.ELEVATOR_DOORS_CLOSED);
		dummyElevator.setPosition(target);					
	}

	@Override
	public long getClockTick() throws RemoteException {
		return 100;
	}

	@Override
	public int getElevatorCnt() throws RemoteException {
		return elevatorCnt;

	}
}
