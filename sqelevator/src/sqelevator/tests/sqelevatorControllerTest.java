package sqelevator.tests;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import sqelevator.ElevatorController;
import sqelevator.ElevatorDataPolling;
import sqelevator.IElevator;

public class sqelevatorControllerTest {

	@Test
	public void testSetDirectionDown() {
		DummyElevatorAdapter2 adapter = new DummyElevatorAdapter2(0, 1, 1000, 4);
		
		// how to do this?? dummy does not work, no interface
		ElevatorDataPolling polling = new ElevatorDataPolling(adapter);
		ElevatorController controller = new ElevatorController(polling, adapter);
		
		controller.startProcessing();
		
		controller.setDirectionDown();
		int expectedDir = IElevator.ELEVATOR_DIRECTION_DOWN;
		int actualDir = 0;
		try {
			actualDir = adapter.GetElevator(0).getCommittedDirection();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(expectedDir, actualDir);
	}
	
	@Test
	public void testSetDirectionUp() {
		DummyElevatorAdapter2 adapter = new DummyElevatorAdapter2(0, 1, 1000, 4);
		
		// how to do this?? dummy does not work, no interface
		ElevatorDataPolling polling = new ElevatorDataPolling(adapter);
		ElevatorController controller = new ElevatorController(polling, adapter);
		
		controller.startProcessing();
		
		controller.setDirectionUp();
		int expectedDir = IElevator.ELEVATOR_DIRECTION_UP;
		int actualDir = 0;
		try {
			actualDir = adapter.GetElevator(0).getCommittedDirection();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(expectedDir, actualDir);
	}
	
	@Test
	public void testSetTarget() {
		DummyElevatorAdapter2 adapter = new DummyElevatorAdapter2(0, 1, 1000, 4);
		
		// how to do this?? dummy does not work, no interface
		ElevatorDataPolling polling = new ElevatorDataPolling(adapter);
		ElevatorController controller = new ElevatorController(polling, adapter);
		
		controller.startProcessing();
		
		controller.setTarget(3);
		int expectedDir = IElevator.ELEVATOR_DIRECTION_UP;
		int actualDir = 0;
		try {
			actualDir = adapter.GetElevator(0).getCommittedDirection();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(expectedDir, actualDir);
		
		
		int expectedTarget = 3;
		int actualTarget = 0;
		try {
			actualTarget = adapter.GetElevator(0).getTarget();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(expectedTarget, actualTarget);
	}
	
	
	
}