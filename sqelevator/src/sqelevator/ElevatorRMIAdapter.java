package sqelevator;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class ElevatorRMIAdapter implements IElevatorAdapter {

	private IElevator controller;
	
	public ElevatorRMIAdapter() {
		try {
			controller = (IElevator) Naming.lookup("rmi://localhost/ElevatorSim");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Elevator GetElevator(int elevatorNumber) throws RemoteException {
		int nrOfFloors = controller.getFloorNum();
		Elevator temp = new Elevator(elevatorNumber,nrOfFloors);		
		temp.setCommittedDirection(controller.getCommittedDirection(elevatorNumber));
		temp.setElevatorAcceleration(controller.getElevatorAccel(elevatorNumber));
		
		boolean requestButtons[] = new boolean[nrOfFloors];
		boolean servicesFloor[] = new boolean[nrOfFloors];
		for (int i = 0; i < nrOfFloors; i++) {
			requestButtons[i] = controller.getElevatorButton(elevatorNumber, i);
			servicesFloor[i] = controller.getServicesFloors(elevatorNumber, i);
		}
		
		temp.setElevatorDoorStatus(controller.getElevatorDoorStatus(elevatorNumber));
		temp.setClosestFloor(controller.getElevatorFloor(elevatorNumber));
		temp.setPosition(controller.getElevatorPosition(elevatorNumber));
		temp.setElevatorSpeed(controller.getElevatorSpeed(elevatorNumber));
		temp.setWeight(controller.getElevatorWeight(elevatorNumber));
		temp.setTarget(controller.getTarget(elevatorNumber));
		temp.setNrofFloors(controller.getFloorNum());		
		temp.setFloorHeight(controller.getFloorHeight());
		temp.setRequestButtons(requestButtons);
		temp.setServicesFloors(servicesFloor);
		
		for(int i = 0; i < nrOfFloors; i++) {
			temp.setFloorButtonDown(i, controller.getFloorButtonDown(i));
			temp.setFloorButtonUp(i, controller.getFloorButtonUp(i));
		}
			
		return temp;
	}

	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException {
		controller.setCommittedDirection(elevatorNumber, direction);
	}

	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException {
		controller.setServicesFloors(elevatorNumber, floor, service);	
	}

	@Override
	public void setTarget(int elevatorNumber, int target) throws RemoteException {
		controller.setTarget(elevatorNumber, target);
	}

	@Override
	public long getClockTick() throws RemoteException {
		return controller.getClockTick();
	}

	@Override
	public int getElevatorCnt() throws java.rmi.RemoteException{
		 
		 return controller.getElevatorNum();
		 
	 }
}
