package sqelevator;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

public class ElevatorController implements Observer {


	private ElevatorDataPolling poller;
	private IElevatorAdapter adapter;
	private Thread pollingThread;
	private boolean automaticMode;
	
	public ElevatorController(ElevatorDataPolling pol,IElevatorAdapter adap ){
		adapter = adap;
		poller = pol;
		poller.addObserver(this);
		
		pollingThread = new Thread(poller);
		automaticMode = false;
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


	@Override
	public void update(Observable arg0, Object arg1) {
		
		 if(arg1 instanceof ElevatorDataPolling) { 
			 
			 ElevatorDataPolling recvData = (ElevatorDataPolling) arg1;
	
			 if (automaticMode) {
				 //do automatic control				 
				 
			 }	
			
		 }
	
	}
	
	
}
