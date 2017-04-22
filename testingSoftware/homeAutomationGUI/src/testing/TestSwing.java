package testing;

import java.util.Random;

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
import javax.swing.event.PopupMenuEvent;

public class TestSwing extends JFrame {

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
		Random rand = new Random();
		int randomTempLivingRoom = rand.nextInt(80 - 70 + 1) + 70;
		
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
		String[] appliances = { "A/C", "Lights", "TV", "Music", "Laundry" };
		JComboBox Schedule = new JComboBox(appliances);
		Schedule.setEnabled(true);
		Schedule.setModel(new DefaultComboBoxModel(new String[] {"A/C", "Lights", "TV", "Music", "Laundry"}));
		
		
		
		JLabel Temperature = new JLabel("Temperature: " + "°F");
		
		//Living Room

		JEditorPane dtrpnLivingRoom = new JEditorPane();
		dtrpnLivingRoom.setEditable(false);
		dtrpnLivingRoom.setBackground(Color.LIGHT_GRAY);
		dtrpnLivingRoom.setText("Living Room\r\n\r\n\r\nTemp: " + randomTempLivingRoom + "°F");
		
		JEditorPane dtrpnBathroom = new JEditorPane();
		dtrpnBathroom.setEditable(false);
		dtrpnBathroom.setBackground(Color.LIGHT_GRAY);
		dtrpnBathroom.setText("Bathroom");
		
		JEditorPane dtrpnBedroom = new JEditorPane();
		dtrpnBedroom.setEditable(false);
		dtrpnBedroom.setBackground(Color.LIGHT_GRAY);
		dtrpnBedroom.setText("Bedroom");
		
		JEditorPane dtrpnGarage = new JEditorPane();
		dtrpnGarage.setEditable(false);
		dtrpnGarage.setBackground(Color.LIGHT_GRAY);
		dtrpnGarage.setText("Garage");
		
		JEditorPane dtrpnKitchen = new JEditorPane();
		dtrpnKitchen.setEditable(false);
		dtrpnKitchen.setBackground(Color.LIGHT_GRAY);
		dtrpnKitchen.setText("Kitchen");
		
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
							.addComponent(dtrpnBathroom, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dtrpnBedroom, 0, 0, Short.MAX_VALUE))
						.addComponent(Schedule, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(dtrpnLivingRoom, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dtrpnGarage, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(dtrpnKitchen, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
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
							.addComponent(dtrpnGarage, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dtrpnKitchen))
						.addComponent(dtrpnLivingRoom, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(dtrpnBedroom)
						.addComponent(dtrpnBathroom, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
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
