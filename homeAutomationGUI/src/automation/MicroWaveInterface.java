package automation;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;


public class MicroWaveInterface extends JFrame{
	
	public MicroWaveInterface()
 {
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 3));

		for (int i = 1; i <= 9; i++) 
		{
			p1.add(new JButton(i + ""));
		}
		
		p1.add(new JButton(0+""));
		p1.add(new JButton("Start"));
		p1.add(new JButton("Stop"));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(new JTextField("Time to be displayed here"), BorderLayout.NORTH);
		p2.add(p1, BorderLayout.CENTER);
		
		add(p2, BorderLayout.EAST);
		add(new JButton("Food to be placed here"), BorderLayout.CENTER);
		
	}

	
	public static void initate() {
		MicroWaveInterface frame = new MicroWaveInterface();
		frame.setVisible(true);
		frame.setTitle("Microwave");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
}
