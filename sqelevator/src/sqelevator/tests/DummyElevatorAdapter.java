package sqelevator.tests;

import java.rmi.RemoteException;

import sqelevator.Elevator;
import sqelevator.IElevatorAdapter;

//dummy only support a single elevator
// dummy
public class DummyElevatorAdapter implements IElevatorAdapter {
	private Elevator dummyElevator;
	private int elevatorCnt;
	
	public DummyElevatorAdapter(int elevatorNum, int elevatorCnt, int committedDirection, int ElevatorAcceleration, int doorStatus, int ElevatorFloor, int ElevatorPosition, int ElevatorSpeed, int ElevatorWeight, int Target, int nrOfFloors ) {
		dummyElevator = new Elevator(elevatorNum, nrOfFloors );
		this.elevatorCnt = elevatorCnt;
		
		dummyElevator.setCommittedDirection(committedDirection);
		dummyElevator.setElevatorAcceleration(ElevatorAcceleration);
		
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
		
		
		dummyElevator.setElevatorDoorStatus(doorStatus);
		dummyElevator.setClosestFloor(ElevatorFloor);
		dummyElevator.setPosition(ElevatorPosition);
		dummyElevator.setElevatorSpeed(ElevatorSpeed);
		dummyElevator.setWeight(ElevatorWeight);
		dummyElevator.setTarget(Target);
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
		dummyElevator.setTarget(target);
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
