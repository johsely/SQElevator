package sqelevator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class ElevatorGUI implements Observer {

	private JFrame frame;
	private JSplitPane splitPane, splitPaneLeft;
	private JPanel panelLeft;
	private JPanel panelRight;
	private Elevator elevator;
	private JLabel payloadValueLabel;
	private JLabel speedValueLabel;
	private JLabel doorstatusValueLabel;
	private JLabel targetsValueLabel;
	private ElevatorController controller;
	private ElevatorDataPolling poller;
	private IElevatorAdapter adapter;
	private JRadioButton autoButton;
	private JButton[] floorButtons;
	
	public ElevatorGUI(IElevatorAdapter adapter, ElevatorDataPolling poller) {
		this.adapter = adapter;
		this.poller = poller;
	}
	
	public void createController() {
		poller.addObserver(this);
		controller = new ElevatorController(poller, adapter);
		controller.startProcessing();
	}
	
	public void addElevatorProgressBar(JSplitPane splitPaneLeft2) {
		ProgressBar elevatorProgressBar = new ProgressBar();
		elevatorProgressBar.runBar();
		splitPaneLeft2.setLeftComponent(elevatorProgressBar);
	}

	public void customizeFloor(JButton floor, Dimension floorDimension, Font floorFont) {
		floor.setPreferredSize(floorDimension);
		floor.setFont(floorFont);
	}

	public void addUpDownPanel(JPanel panel, final int floorNumber) {
		JPanel upDownPanel = new JPanel();
		upDownPanel.setLayout(new java.awt.GridLayout(2, 2));
		if (floorNumber == 0) {
			JRadioButton buttonUp = new JRadioButton();
			upDownPanel.add(buttonUp);
			upDownPanel.add(new JLabel("       Up"));
		} else if (floorNumber < 4) {
			ButtonGroup buttonGroup = new ButtonGroup();
			JRadioButton buttonUp = new JRadioButton();
			JRadioButton buttonDown = new JRadioButton();
			buttonGroup.add(buttonUp);
			buttonGroup.add(buttonDown);
			upDownPanel.add(buttonUp);
			upDownPanel.add(new JLabel("Up"));
			upDownPanel.add(buttonDown);
			upDownPanel.add(new JLabel("Down"));
		} else {
			JRadioButton buttonDown = new JRadioButton();
			upDownPanel.add(buttonDown);
			upDownPanel.add(new JLabel("       Down"));
		}

		panel.add(upDownPanel);
	}

	public void addDirectionInfo(JPanel panel) {
		JPanel directionPanel = new JPanel();
		Font directionFont = new Font("Verdana", Font.BOLD, 15);
		JTextArea upDirection = new JTextArea("Up");
		upDirection.setFont(directionFont);
		JTextArea downDirection = new JTextArea("Down");
		downDirection.setFont(directionFont);
		// upDirection.setVisible(false);
		// downDirection.setVisible(false);
		directionPanel.add(upDirection);
		directionPanel.add(downDirection);
		panel.add(directionPanel);
	}

	public void addElevatorInfos(JPanel panel) {
		JPanel elevatorInfos = new JPanel(new java.awt.GridLayout(4, 2));
		JLabel payloadLabel = new JLabel("Payload:     ");
		JLabel speedLabel = new JLabel("Speed:  ");
		JLabel doorstatusLabel = new JLabel("Door Status:  ");
		JLabel targetsLabel = new JLabel("Target:  ");
		payloadValueLabel = new JLabel("0");
		speedValueLabel = new JLabel("0");
		doorstatusValueLabel = new JLabel("0");
		targetsValueLabel = new JLabel("0");

		elevatorInfos.add(payloadLabel);
		elevatorInfos.add(payloadValueLabel);
		elevatorInfos.add(speedLabel);
		elevatorInfos.add(speedValueLabel);
		elevatorInfos.add(doorstatusLabel);
		elevatorInfos.add(doorstatusValueLabel);
		elevatorInfos.add(targetsLabel);
		elevatorInfos.add(targetsValueLabel);
		panel.add(elevatorInfos);
	}

	public void addModePanel(JPanel panel) {
		JPanel modePanel = new JPanel();
		modePanel.add(new JLabel("Automatic Mode: "));
		autoButton = new JRadioButton();
		autoButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	controller.setTarget(3);
		    }
		});
		modePanel.add(autoButton);
		modePanel.add(new JLabel("Manual Mode:"));
		modePanel.add(new JRadioButton());
		panel.add(modePanel);
	}
	
	public void setFloorColors() {
		for (int i = 0; i < 5; i++) {
			floorButtons[i].setForeground(Color.BLACK);
			floorButtons[i].setBackground(Color.GRAY);
		}
	}
	
	public void addFloorListeners() {
		for (int i = 0; i < 5; i++) {
			floorButtons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton floorButton = (JButton)e.getSource();
					controller.setTarget(Integer.parseInt(floorButton.getText()));
				}
			});
		}
	}

	public void CreateGUI() {
		// create frame
		frame = new JFrame();
		frame.setTitle("ElevatorGUI");

		// create splitPane
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		// create panels with their subPanels
		splitPaneLeft = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		addElevatorProgressBar(splitPaneLeft);
		panelLeft = new JPanel();
		panelLeft.setLayout(new javax.swing.BoxLayout(panelLeft, javax.swing.BoxLayout.Y_AXIS));
		JPanel panelZero = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelOne = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelTwo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelThree = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelFour = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panelRight = new JPanel();

		// create floors
		Dimension floorDimension = new Dimension(50, 100);
		Font floorFont = new Font("Verdana", Font.BOLD, 20);
		floorButtons = new JButton[5];
		for (int i = 0; i < 5; i++) {
			floorButtons[i] = new JButton(String.valueOf(i));
			customizeFloor(floorButtons[i], floorDimension, floorFont);
		}
		
		// add floors to subPanels
		panelZero.add(floorButtons[0]);
		panelOne.add(floorButtons[1]);
		panelTwo.add(floorButtons[2]);
		panelThree.add(floorButtons[3]);
		panelFour.add(floorButtons[4]);

		// add up and down to subPanels
		addUpDownPanel(panelZero, 0);
		addUpDownPanel(panelOne, 1);
		addUpDownPanel(panelTwo, 2);
		addUpDownPanel(panelThree, 3);
		addUpDownPanel(panelFour, 4);

		// add direction info
		addDirectionInfo(panelZero);

		// add subPanels to panelLeft
		panelLeft.add(panelFour);
		panelLeft.add(panelThree);
		panelLeft.add(panelTwo);
		panelLeft.add(panelOne);
		panelLeft.add(panelZero);
		splitPaneLeft.setRightComponent(panelLeft);

		// add elevator infos and mode to panelRight
		addElevatorInfos(panelRight);
		addModePanel(panelRight);

		// add panel to splitPane
		splitPane.setLeftComponent(splitPaneLeft);
		splitPane.setRightComponent(panelRight);

		// add splitPane to frame
		frame.add(splitPane);
		
		// create controller
		createController();
		
		// add listeners to buttons
		addFloorListeners();

		// set frame to suitable size and set it visible
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	

	@Override
	public void update(Observable arg0, Object arg1) {

		if (arg0 instanceof ElevatorDataPolling) {

			ElevatorDataPolling recvData = (ElevatorDataPolling) arg0;
			elevator = recvData.GetElevator();
			payloadValueLabel.setText(String.valueOf(elevator.getElevatorWeight()));
			speedValueLabel.setText(String.valueOf(elevator.getElevatorSpeed()));
			doorstatusValueLabel.setText(String.valueOf(elevator.getElevatorDoorStatus()));
			targetsValueLabel.setText(String.valueOf(elevator.getTarget()));
			setFloorColors();
			floorButtons[elevator.getTarget()].setForeground(Color.GREEN);
			floorButtons[elevator.getClosestFloor()].setBackground(Color.RED);;
		}
	}

}
