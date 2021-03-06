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

	public ElevatorController(ElevatorDataPolling pol, IElevatorAdapter adap) {
		adapter = adap;
		poller = pol;
		poller.addObserver(this);
		numberOfFloors = 5;
		pollingThread = new Thread(poller);
		automaticMode = false;
	}

	public void setAutomaticMode(boolean enable) {

		automaticMode = enable;
	}

	public void startProcessing() {
		pollingThread.start();

	}

	public void setDirectionUp() throws RemoteException {		
			adapter.setCommittedDirection(0, IElevator.ELEVATOR_DIRECTION_UP);
	}

	public void setDirectionDown() throws RemoteException {
			adapter.setCommittedDirection(0, IElevator.ELEVATOR_DIRECTION_DOWN);
	}

	public void setTarget(int floor) throws RemoteException {		
			adapter.setTarget(0, floor);
	}

	public int getNextFloor(Elevator elev) {

		// get closest next floor from current.
		int differencetmp;
		int difference = 10;
		int nextTarget = currentFloor;
		for (int i = 0; i < numberOfFloors; ++i) {

			if (currentFloor != i) {
				if (elev.getElevatorButton(i) || elev.getFloorButtonDown(i) || elev.getFloorButtonUp(i)) { // pressed

					if (currentFloor > i)
						differencetmp = currentFloor - i;
					else
						differencetmp = i - currentFloor;

					if (differencetmp < difference) {
						difference = differencetmp;
						nextTarget = i;
					}
				}
			}

		}

		return nextTarget;

	}

	@Override
	public void update(Observable arg0, Object arg1) {

		if (arg0 instanceof ElevatorDataPolling) {

			ElevatorDataPolling recvData = (ElevatorDataPolling) arg0;
			if (automaticMode) {
				Elevator elev = recvData.GetElevator();

				if (elev.getElevatorSpeed() == 0) {
					currentFloor = elev.getClosestFloor();

					// move only when doors are opened
					if (elev.getElevatorDoorStatus() == IElevator.ELEVATOR_DOORS_OPEN) {
						try {
							setTarget(getNextFloor(elev));
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}

			}

		}

	}

}
