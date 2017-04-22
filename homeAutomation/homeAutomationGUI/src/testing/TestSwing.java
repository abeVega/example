package testing;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.PopupMenuListener;

import javafx.application.Platform;

import javax.swing.event.PopupMenuEvent;

public class TestSwing extends JFrame {
	int temp = 70;
	int livTemp = temp;
	int inputTemp = 0;
	int holder = 0;
	
	int kitColor, livColor, garColor, bathColor, bedColor = 0;
	
	
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=372,239
	 */
	private final Panel panel = new Panel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSwing frame = new TestSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestSwing() {
		JEditorPane LivingRoom = new JEditorPane();
		LivingRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LivingRoom.setBackground(Color.orange);

			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		//Appliance Control
		JLabel Temperature = new JLabel("Temperature: " + temp +"°F");
		String[] appliances = { "A/C", "TV", "Music", "Laundry" };
		JComboBox Schedule = new JComboBox(appliances);
		
		Schedule.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String selectedAppliance = (String) Schedule.getSelectedItem();
				
				//Temperature
				if(selectedAppliance == "A/C"){
					TempSim.main(appliances);
					temp = TempSim.returnTemp();
					livTemp = temp;
					Temperature.setText("Temperature: " + temp +"°F");
					LivingRoom.setText("Living Room\r\n\r\n\r\nTemp: " + livTemp + "°F");
					
				}
				
				//Lights Scheduling Options
				if(selectedAppliance == "Lights"){
				}
			}
		});
		
		//Living Room
		LivingRoom.setEditable(false);
		LivingRoom.setBackground(Color.LIGHT_GRAY);
		LivingRoom.setText("Living Room\r\n\r\n\r\nTemp: " + livTemp + "°F");
		LivingRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(livColor == 1){
					LivingRoom.setBackground(Color.LIGHT_GRAY);
					livColor = 0;
				}
				else if(livColor == 0){
					LivingRoom.setBackground(Color.ORANGE);
					livColor = 1;
				}
			}
		});
		
		//Bathroom
		JEditorPane Bathroom = new JEditorPane();
		Bathroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bathColor == 1){
					Bathroom.setBackground(Color.LIGHT_GRAY);
					bathColor = 0;
				}
				else if(bathColor == 0){
					Bathroom.setBackground(Color.ORANGE);
					bathColor = 1;
				}
			}
		});
		Bathroom.setEditable(false);
		Bathroom.setBackground(Color.LIGHT_GRAY);
		Bathroom.setText("Bathroom");
		
		
		
		//Bedroom
		JEditorPane Bedroom = new JEditorPane();
		Bedroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bedColor == 1){
					Bedroom.setBackground(Color.LIGHT_GRAY);
					bedColor = 0;
				}
				else if(bedColor == 0){
					Bedroom.setBackground(Color.ORANGE);
					bedColor = 1;
				}
			}
		});
		Bedroom.setEditable(false);
		Bedroom.setBackground(Color.LIGHT_GRAY);
		Bedroom.setText("Bedroom");
		
		
		
		
		//Garage
		JEditorPane Garage = new JEditorPane();
		Garage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(garColor == 1){
					Garage.setBackground(Color.LIGHT_GRAY);
					garColor = 0;
				}
				else if(garColor == 0){
					Garage.setBackground(Color.ORANGE);
					garColor = 1;
				}
			}
		});
		Garage.setEditable(false);
		Garage.setBackground(Color.LIGHT_GRAY);
		Garage.setText("Garage");
		
		
		
		//Kitchen
		JEditorPane Kitchen = new JEditorPane();
		Kitchen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(kitColor == 1){
					Kitchen.setBackground(Color.LIGHT_GRAY);
					kitColor = 0;
				}
				else if(kitColor == 0){
					Kitchen.setBackground(Color.ORANGE);
					kitColor = 1;
				}
			}
		});
		Kitchen.setEditable(false);
		Kitchen.setBackground(Color.LIGHT_GRAY);
		Kitchen.setText("Kitchen");
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Temperature)
					.addContainerGap(340, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Bathroom, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Bedroom, 0, 0, Short.MAX_VALUE))
						.addComponent(Schedule, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(LivingRoom, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(Garage, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(Kitchen, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
					.addGap(101))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Temperature)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Garage, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Kitchen))
						.addComponent(LivingRoom, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Bedroom)
						.addComponent(Bathroom, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Schedule, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}