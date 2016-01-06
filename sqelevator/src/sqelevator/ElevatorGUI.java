package sqelevator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class ElevatorGUI {

	private static JFrame frame;
	private static JSplitPane splitPane;
	private static JPanel panelLeft;
	private static JPanel panelRight;

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

	public static void main(String[] args) {
		// create frame
		frame = new JFrame();
		frame.setTitle("ElevatorGUI");
		
		// create splitPane
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		// create panels with their subPanels
		panelLeft = new JPanel();
		panelLeft.setLayout(new javax.swing.BoxLayout(panelLeft, javax.swing.BoxLayout.Y_AXIS));
		JPanel panelZero = new JPanel();
		JPanel panelOne = new JPanel();
		JPanel panelTwo = new JPanel();
		JPanel panelThree = new JPanel();
		JPanel panelFour = new JPanel();
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
		
		// add subPanels to panelLeft
		panelLeft.add(panelZero);
		panelLeft.add(panelOne);
		panelLeft.add(panelTwo);
		panelLeft.add(panelThree);
		panelLeft.add(panelFour);
		
		// TODO panelRight
		panelRight.setBackground(Color.BLACK);
		
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
