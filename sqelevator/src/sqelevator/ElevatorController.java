package sqelevator;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import sqelevator.IElevator;

public class ElevatorController extends UnicastRemoteObject implements IElevator
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3313924767629828887L;
	
	
	private ArrayList<Elevator> elevators;
	private ArrayList<Floor> floors;
	private MySystem myHouse;

	protected ElevatorController() throws RemoteException
	{
		super();

		myHouse = new MySystem();

		floors = new ArrayList<Floor>();
		floors.add(new Floor());
		floors.add(new Floor());
		floors.add(new Floor());

		elevators = new ArrayList<Elevator>();
		elevators.add(new Elevator(floors.size()));
	}

	/**
	 * main method
	 *
	 * @param _args console parameters
	 */
	public static void main(String[] _args)
	{
		try
		{
			System.out.println("create registry at port " + Registry.REGISTRY_PORT);
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

			System.setProperty(
				"java.rmi.server.codebase",
				"http://" + (InetAddress.getLocalHost()).getHostName() + ":8081/ElevatorSim");

			String rmiAddress = "rmi://" + (InetAddress.getLocalHost()).getHostName() + "/" + "ElevatorSim";
			System.out.println("starting service at " + rmiAddress);
			Naming.rebind(rmiAddress, new ElevatorController());

		}
		catch (RemoteException e)
		{
			System.out.println("remote exception occured");
			e.printStackTrace();
		}
		catch (UnknownHostException e)
		{
			System.out.println("could not find the host");
			e.printStackTrace();
		}
		catch (MalformedURLException e)
		{
			System.out.println("bad url exception occured");
			e.printStackTrace();
		}
	}

	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException
	{
		return elevators.get(elevatorNumber).getCommittedDirection();
	}

	@Override
	public int getElevatorAccel(int elevatorNumber) throws RemoteException
	{
		return elevators.get(elevatorNumber).getElevatorAccel();
	}

	@Override
	public boolean getElevatorButton(int elevatorNumber, int floor)
		throws RemoteException
	{
		return elevators.get(elevatorNumber).getElevatorButton(floor);
	}

	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException
	{
		return elevators.get(elevatorNumber).getElevatorDoorStatus();
	}

	@Override
	public int getElevatorFloor(int elevatorNumber) throws RemoteException
	{
		return elevators.get(elevatorNumber).getElevatorFloor();
	}

	@Override
	public int getElevatorNum() throws RemoteException
	{
		return elevators.size();
	}

	@Override
	public int getElevatorPosition(int elevatorNumber) throws RemoteException
	{
		return elevators.get(elevatorNumber).getElevatorPosition();
	}

	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException
	{
		return elevators.get(elevatorNumber).getElevatorSpeed();
	}

	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException
	{
		return elevators.get(elevatorNumber).getElevatorWeight();
	}

	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException
	{
		return elevators.get(elevatorNumber).getElevatorCapacity();
	}

	@Override
	public boolean getFloorButtonDown(int floor) throws RemoteException
	{
		return floors.get(floor).getFloorButtonDown();
	}

	@Override
	public boolean getFloorButtonUp(int floor) throws RemoteException
	{
		return floors.get(floor).getFloorButtonUp();
	}

	@Override
	public int getFloorHeight() throws RemoteException
	{
		return myHouse.getFloorHeight();
	}

	@Override
	public int getFloorNum() throws RemoteException
	{
		return floors.size();
	}

	@Override
	public boolean getServicesFloors(int elevatorNumber, int floor)
		throws RemoteException
	{
		return elevators.get(elevatorNumber).getServicesFloors(floor);
	}

	@Override
	public int getTarget(int elevatorNumber) throws RemoteException
	{
		return elevators.get(elevatorNumber).getTarget();
	}

	@Override
	public void setCommittedDirection(int elevatorNumber, int direction)
		throws RemoteException
	{
		elevators.get(elevatorNumber).setCommittedDirection(direction);
	}

	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service)
		throws RemoteException
	{
		elevators.get(elevatorNumber).setServicesFloors(floor, service);
	}

	@Override
	public void setTarget(int elevatorNumber, int target)
		throws RemoteException
	{
		elevators.get(elevatorNumber).setTarget(target);
	}

	@Override
	public long getClockTick() throws RemoteException
	{
		return myHouse.getClockTick();
	}

}
