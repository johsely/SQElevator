package sqelevator;

import java.rmi.RemoteException;
import java.util.Observable;

public class ModeManual extends ModeBase {

	
	public ModeManual(IElevatorAdapter adap)  {
		 super(adap);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		 if(arg instanceof ElevatorDataPolling) { 
		 
			 ElevatorDataPolling recvData = (ElevatorDataPolling) arg;
	
			 
			elev = recvData.elevators[0]; //FIXME THREADSAFE???   only one elevator supported
			
			
		 }
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

	

}
