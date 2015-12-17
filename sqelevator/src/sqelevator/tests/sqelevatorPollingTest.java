package sqelevator.tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import sqelevator.Elevator;
import sqelevator.ElevatorDataPolling;

public class sqelevatorPollingTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testPollingSimpleGetElevatorNum() {
		
		
		DummyElevatorAdapter adapter = new DummyElevatorAdapter(0,1,1,1,1,1,1,1,1,1,2);
		ElevatorDataPolling poll = new ElevatorDataPolling(adapter);
		poll.initialize();
		poll.runDataPolling();
		assertEquals(0,poll.elevators[0].getElevatorNum());
	}
	
	
	@Test
	public void testPollingNegativeFloors() {
		
		exception.expect(RuntimeException.class);
		exception.expectMessage("Minimum Floors is 2!");
		
		DummyElevatorAdapter adapter = new DummyElevatorAdapter(2,2,1,1,1,1,1,1,1,1,-1);
		ElevatorDataPolling poll = new ElevatorDataPolling(adapter);
		
	
	}
	@Test
	public void testPollingOneFloor() {
		
		exception.expect(RuntimeException.class);
		exception.expectMessage("Minimum Floors is 2!");
		
		DummyElevatorAdapter adapter = new DummyElevatorAdapter(2,2,1,1,1,1,1,1,1,1,1);
		ElevatorDataPolling poll = new ElevatorDataPolling(adapter);
		
	}
	
	@Test
	public void testPollingElevatorNumNegative() {
		
		exception.expect(RuntimeException.class);
		exception.expectMessage("Minimum Elevator Num is 0!");
		
		DummyElevatorAdapter adapter = new DummyElevatorAdapter(-1,2,1,1,1,1,1,1,1,1,1);
		ElevatorDataPolling poll = new ElevatorDataPolling(adapter);
		
	}
	@Test
	public void testPollingElevatorOk() {
		
		
		DummyElevatorAdapter adapter = new DummyElevatorAdapter(2,2,1,1,1,1,1,1,1,1,2);
		ElevatorDataPolling poll = new ElevatorDataPolling(adapter);
		poll.initialize();
		poll.runDataPolling();
		
		assertEquals(2,poll.elevators[1].getElevatorNum());
		assertEquals(1,poll.elevators[1].getCommittedDirection());	
		assertEquals(1,poll.elevators[1].getElevatorAcceleration());
		assertEquals(1,poll.elevators[1].getElevatorDoorStatus());
		assertEquals(1,poll.elevators[1].getClosestFloor());
		assertEquals(1,poll.elevators[1].getElevatorPosition());
		assertEquals(1,poll.elevators[1].getElevatorSpeed());
		assertEquals(1,poll.elevators[1].getElevatorWeight());
		assertEquals(1,poll.elevators[1].getTarget());
		assertEquals(2,poll.elevators[1].getNrOfFloors());	
		
		assertTrue(poll.elevators[1].getFloorButtonDown(0));
		assertTrue(poll.elevators[1].getFloorButtonDown(1));
		assertTrue(poll.elevators[1].getFloorButtonUp(0));
		assertTrue(poll.elevators[1].getFloorButtonUp(1));
		
		assertTrue(poll.elevators[1].getServicesFloors(0));
		assertTrue(poll.elevators[1].getServicesFloors(1));
		
		assertTrue(poll.elevators[1].getRequestButtons()[0]);
		assertTrue(poll.elevators[1].getRequestButtons()[0]);	
	}
	
	
	
}
