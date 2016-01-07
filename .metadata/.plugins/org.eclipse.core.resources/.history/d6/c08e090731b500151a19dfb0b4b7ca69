package sqelevator;

import java.rmi.RemoteException;

public class ElevatorController {

	private ModeBase Mode;
	private ElevatorDataPolling poller;
	private IElevatorAdapter adapter;
	private Thread pollingThread;
	
	public ElevatorController(ElevatorDataPolling pol,IElevatorAdapter adap ){
		adapter = adap;
		poller = pol;
		Mode   = new ModeManual(adap);
		poller.addObserver(Mode);
		pollingThread = new Thread(poller);
	}
	
	
	public void startProcessing(){
		pollingThread.start();	
		
	}
	
	//add functions that can be accessed from gui
	
	
	public Elevator getElevatorInfo() {
		
		return Mode.elev;
	}

	public void setDirectionUp() {
		
		try {
			Mode.setCommittedDirection(0, IElevator.ELEVATOR_DIRECTION_UP);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void setDirectionDown() {
		
		try {
			Mode.setCommittedDirection(0, IElevator.ELEVATOR_DIRECTION_DOWN);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void setTarget(int floor){
		try {
			Mode.setTarget(0, floor);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

	
	
}
