package sqelevator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javafx.scene.control.RadioButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class ElevatorGUI {

	private static JFrame frame;
	private static JSplitPane splitPane;
	private static JPanel panelLeft;
	private static JPanel panelRight;
	
	public static void addElevatorProgressBar(JPanel panel) {
		JProgressBar elevatorProgressBar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
		panel.add(elevatorProgressBar);
	}
	
	public static void customizeFloor(JTextArea floor,
			Dimension floorDimension, Font floorFont) {
		floor.setPreferredSize(floorDimension);
		floor.setFont(floorFont);
		floor.setEditable(false);
	}
	
	public static void addUpDownPanel(JPanel panel) {
		JPanel upDownPanel = new JPanel();
		upDownPanel.setLayout(new java.awt.GridLayout(2, 2));
		upDownPanel.add(new JRadioButton());
		upDownPanel.add(new JLabel("Up"));
		upDownPanel.add(new JRadioButton());
		upDownPanel.add(new JLabel("Down"));
		panel.add(upDownPanel);
	}
	
	public static void addDirectionInfo(JPanel panel) {
		JPanel directionPanel = new JPanel();
		Font directionFont = new Font("Verdana", Font.BOLD, 15);
		JTextArea upDirection = new JTextArea("Up");
		upDirection.setFont(directionFont);
		JTextArea downDirection = new JTextArea("Down");
		downDirection.setFont(directionFont);
//		upDirection.setVisible(false);
//		downDirection.setVisible(false);
		directionPanel.add(upDirection);
		directionPanel.add(downDirection);
		panel.add(directionPanel);
	}
	
	public static void addElevatorInfos(JPanel panel) {
		JPanel elevatorInfos = new JPanel(new java.awt.GridLayout(4, 2));
		JLabel payloadLabel = new JLabel("Payload:     ");
		JLabel speedLabel = new JLabel("Speed:  ");
		JLabel doorstatusLabel = new JLabel("Door Status:  ");
		JLabel targetsLabel = new JLabel("Targets:  ");
		JLabel payloadValueLabel = new JLabel("0");
		JLabel speedValueLabel = new JLabel("0");
		JLabel doorstatusValueLabel = new JLabel("0");
		JLabel targetsValueLabel = new JLabel("0");
		
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
	
	public static void addModePanel(JPanel panel) {
		JPanel modePanel = new JPanel();
		modePanel.add(new JLabel("Automatic Mode: "));
		modePanel.add(new JRadioButton());
		modePanel.add(new JLabel("Manual Mode:"));
		modePanel.add(new JRadioButton());
		panel.add(modePanel);
	}

	public static void main(String[] args) {
		// create frame
		frame = new JFrame();
		frame.setTitle("ElevatorGUI");
		
		// create splitPane
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		// create panels with their subPanels
		panelLeft = new JPanel();
		panelLeft.setLayout(new javax.swing.BoxLayout(panelLeft, javax.swing.BoxLayout.Y_AXIS));
		// TODO
		addElevatorProgressBar(panelLeft);
		JPanel panelZero = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelOne = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelTwo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelThree = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelFour = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelRight = new JPanel();
		
		// create floors
		Dimension floorDimension = new Dimension(50, 100);
		Font floorFont = new Font("Verdana", Font.BOLD, 20);
		JTextArea floorFour = new JTextArea("4");
		customizeFloor(floorFour, floorDimension, floorFont);
		JTextArea floorThree = new JTextArea("3");
		customizeFloor(floorThree, floorDimension, floorFont);
		JTextArea floorTwo = new JTextArea("2");
		customizeFloor(floorTwo, floorDimension, floorFont);
		JTextArea floorOne = new JTextArea("1");
		customizeFloor(floorOne, floorDimension, floorFont);
		JTextArea floorZero = new JTextArea("0");
		customizeFloor(floorZero, floorDimension, floorFont);
		
		// add floors to subPanels
		panelZero.add(floorZero);
		panelOne.add(floorOne);
		panelTwo.add(floorTwo);
		panelThree.add(floorThree);
		panelFour.add(floorFour);
				
		// add up and down to subPanels
		addUpDownPanel(panelZero);
		addUpDownPanel(panelOne);
		addUpDownPanel(panelTwo);
		addUpDownPanel(panelThree);
		addUpDownPanel(panelFour);
		
		// add direction info
		addDirectionInfo(panelZero);
		
		// add subPanels to panelLeft
		panelLeft.add(panelZero);
		panelLeft.add(panelOne);
		panelLeft.add(panelTwo);
		panelLeft.add(panelThree);
		panelLeft.add(panelFour);
		
		// add elevator infos and mode to panelRight
		addElevatorInfos(panelRight);
		addModePanel(panelRight);
		
		// add panel to splitPane
		splitPane.setLeftComponent(panelLeft);
		splitPane.setRightComponent(panelRight);

		// add splitPane to frame
		frame.add(splitPane);

		// set frame to suitable size and set it visible
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

}
