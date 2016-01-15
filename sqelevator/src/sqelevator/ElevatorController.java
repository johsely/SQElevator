package sqelevator;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

public class ElevatorController implements Observer {


	private ElevatorDataPolling poller;
	private IElevatorAdapter adapter;
	private Thread pollingThread;
	private boolean automaticMode;
	
	
	
	private int numberOfFloors;
	private int currentFloor;
	private boolean[] destFloors;
	
	
	public ElevatorController(ElevatorDataPolling pol,IElevatorAdapter adap ){
		adapter = adap;
		poller = pol;
		poller.addObserver(this);
		destFloors =  new boolean[numberOfFloors];
		pollingThread = new Thread(poller);
		automaticMode = false;
	}
	
	public void setAutomaticMode(boolean enable) {
		
		automaticMode = enable;
	}
	
	
	public void startProcessing(){
		pollingThread.start();	
		
	}
	

	public void setDirectionUp() {
		
		try {
			adapter.setCommittedDirection(0, IElevator.ELEVATOR_DIRECTION_UP);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void setDirectionDown() {
		
		try {
			adapter.setCommittedDirection(0, IElevator.ELEVATOR_DIRECTION_DOWN);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void setTarget(int floor){
		try {
			adapter.setTarget(0, floor);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int getNextFloor(Elevator elev) {
		
		//get closest next floor from current.
		int differencetmp;
		int difference = -1;
		int nextTarget = currentFloor;
		for (int i = 0; i< numberOfFloors; ++i){
			
			if (destFloors[i] ||elev.getFloorButtonDown(i) || elev.getFloorButtonUp(i)) {  // pressed
				
				if (currentFloor> i) differencetmp = currentFloor - i;
				else 				 differencetmp = i - currentFloor;
				
				
				if (differencetmp < difference){
					difference = differencetmp;
					nextTarget = i;
				}
			}

			
		}
		
		return nextTarget;
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		 if(arg0 instanceof ElevatorDataPolling) { 
			 
			 ElevatorDataPolling recvData = (ElevatorDataPolling) arg0;
			 //recvData.GetElevator();
			 if (automaticMode) {
				 Elevator elev = recvData.GetElevator();
				 
				 if (elev.getElevatorSpeed() == 0) {
					 currentFloor = elev.getClosestFloor();
					 
					 for ( int i = 0; i< numberOfFloors; ++i) {
						 
						 destFloors[i] = elev.getElevatorButton(i);
					 }
					 
					 //move only when doors are closed
					 if (elev.getElevatorDoorStatus() ==IElevator.ELEVATOR_DOORS_CLOSED)
					 {
						 setTarget(getNextFloor(elev));
						 					 
					 }
				 }

			 }	
			
		 }
	
	}
	
	
}
