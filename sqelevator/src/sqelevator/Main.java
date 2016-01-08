package sqelevator;

public class Main {

	public static void main(String[] args) {
		IElevatorAdapter adapter = new ElevatorRMIAdapter();
		ElevatorDataPolling poller = new ElevatorDataPolling(adapter);
		ElevatorGUI elevatorGUI = new ElevatorGUI(adapter, poller);
		elevatorGUI.CreateGUI();
	}

}
