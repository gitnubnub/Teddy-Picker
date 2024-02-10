import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class TeddyPicker {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Teddy Picker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUI(frame);
		frame.setSize(560, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static void createUI(final JFrame frame) {
		JPanel panel = new JPanel(null);
		JButton run = new JButton("Let's have a game on the Teddy Picker!");
		run.setBounds(180, 255, 200, 30);

		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen(panel);
			}
		});

		panel.add(run);
		frame.getContentPane().add(panel);
	}

	public static void mainScreen(JPanel panel) {
		final JLabel howMany = new JLabel("How many playlists are you choosing from?");
		howMany.setBounds(175, 40, 210, 30);
		final JTextField noOfPlaylists = new JTextField();
		noOfPlaylists.setBounds(180, 80, 200, 30);
		JButton submitNo = new JButton("Go");
		submitNo.setBounds(180, 160, 200, 30);

		submitNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = 0;

				try {
					if (number > 0) {
						number = Integer.parseInt(noOfPlaylists.getText());
						inputScreen(panel, number);
					} else {
						final JLabel error = new JLabel("Invalid input, please enter a number higher than zero!");
						error.setBounds(180, 240, 200, 30);
						panel.add(error);
					}
				} catch (NumberFormatException ex) {
					final JLabel error = new JLabel("Invalid input, please enter a number higher than zero!");
					error.setBounds(180, 240, 200, 30);
					panel.add(error);
				}
			}
		});

		panel.add(howMany);
		panel.add(noOfPlaylists);
		panel.add(submitNo);
		panel.revalidate();
		panel.repaint();
	}

	public static void inputScreen(JPanel panel, int number); {
		panel.revalidate();
		panel.repaint();
	}
}