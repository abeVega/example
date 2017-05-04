package automation;

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
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.event.PopupMenuListener;

import javafx.application.Platform;

import javax.swing.event.PopupMenuEvent;
import javax.swing.JTextArea;

public class GUI extends JFrame {
	int temp = 70;
	int bathTemp = 75, garageTemp = 70, kitchenTemp = 76, livTemp = 70;
	int holder, inputTemp, kitColor, livColor, garColor, bathColor, bedColor = 0;
	
	private JPanel contentPane;
	private final Panel panel = new Panel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creates the frame
	public GUI() {
		JEditorPane LivingRoom = new JEditorPane();
		LivingRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LivingRoom.setBackground(Color.orange);

			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] appliances = { "A/C", "TV", "Entertainment", "Appliances" };
		JComboBox Schedule = new JComboBox(appliances);
		
		Schedule.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String selectedAppliance = (String) Schedule.getSelectedItem();
				
				//Temperature
				if(selectedAppliance == "A/C"){
					tempControl.main(appliances);
					temp = tempControl.returnTemp();
					livTemp = temp;
					LivingRoom.setText("Living Room\r\n\r\n\r\nTemp: " + livTemp + "°F");
					
				}
				//Lights Scheduling Options
				if(selectedAppliance == "Lights"){
				}
				
				//Entertainment Scheduling Options
				if(selectedAppliance == "Entertainment"){
				}
				
				//Appliances Options
				if(selectedAppliance == "Appliances"){
					//This will open menu (maybe JavaFX) with different appliances, e.g., toaster, dishwasher, 
				}
			}
		});
		
		//Living Room
		LivingRoom.setEditable(false);
		LivingRoom.setBackground(Color.LIGHT_GRAY);
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
		java.net.URL url1 = getClass().getResource("imgres.png");
		java.net.URL url2 = getClass().getResource("imgres2.png");
		Bathroom.setContentType("text/html");
		Bathroom.setText("<html><body>Bathroom " + bathTemp + "&#8457;<br /><img src='" + url1 + "'></body></html>");
		
		Bathroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bathColor == 1){
					//Bathroom.setBackground(Color.LIGHT_GRAY);
					Bathroom.setText("<html><body style='color: #ffffff;'>Bathroom " + bathTemp + "&#8457;<br /><img src='" + url1 + "'></body></html>");
					bathColor = 0;
				}
				else if(bathColor == 0){
					//Bathroom.setBackground(Color.ORANGE);
					Bathroom.setText("<html><body style='color: #ffffff;'>Bathroom " + bathTemp + "&#8457;<br /><img style ='filter: brightness(50%)'; src='" + url2 + "'></body></html>");
					bathColor = 1;
				}
			}
		});
		Bathroom.setEditable(false);
		Bathroom.setBackground(Color.LIGHT_GRAY);
		
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
		
		
		
		//Front Yard
		JEditorPane FrontYard = new JEditorPane();
		FrontYard.setText("Front Yard");
		FrontYard.setEditable(false);
		FrontYard.setBackground(Color.LIGHT_GRAY);
		
		JEditorPane Backyard = new JEditorPane();
		Backyard.setText("Backyard");
		Backyard.setEditable(false);
		Backyard.setBackground(Color.LIGHT_GRAY);
		
		ImageIcon icon = createImageIcon("imgres.png", "title");
		
		JTextArea textArea = new JTextArea(
				"What you type in here appears in the JTextArea"
				);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		JButton btnScheduler = new JButton("Scheduler");
		btnScheduler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Code in here is executed when the button is clicked
				
			}
		});
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnScheduler, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
									.addGap(50)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(Bathroom, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Bedroom, 0, 0, Short.MAX_VALUE))
										.addComponent(LivingRoom, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(Backyard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Garage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Kitchen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(FrontYard, 0, 0, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(139)
							.addComponent(Schedule, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(FrontYard, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(LivingRoom, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(Garage, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Kitchen, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
						.addComponent(textArea))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Bathroom, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
								.addComponent(Bedroom)
								.addComponent(Backyard)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(btnScheduler, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(Schedule, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(54))
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
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
		return null;
		}
	}
}