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

	public static void createUI(final JFrame frame) {
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
		panel.removeAll();

		final JLabel howMany = new JLabel("How many playlists are you choosing from?");
		howMany.setBounds(175, 40, 210, 30);
		final JTextField noOfPlaylists = new JTextField();
		noOfPlaylists.setBounds(180, 80, 200, 30);
		JButton submitNo = new JButton("Go");
		submitNo.setBounds(180, 160, 200, 30);

		submitNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = Integer.parseInt(noOfPlaylists.getText());

				try {
					if (number > 0) {
						inputScreen(panel, number);
					} else {
						final JLabel error = new JLabel("Invalid input, please enter a number higher than zero!");
						error.setBounds(180, 200, 200, 30);
						panel.add(error);
						panel.revalidate();
						panel.repaint();
					}
				} catch (NumberFormatException ex) {
					final JLabel error = new JLabel("Invalid input, please enter a number higher than zero!");
					error.setBounds(180, 200, 200, 30);
					panel.add(error);
					panel.revalidate();
					panel.repaint();
				}
			}
		});

		panel.add(howMany);
		panel.add(noOfPlaylists);
		panel.add(submitNo);
		panel.revalidate();
		panel.repaint();
	}

	public static void inputScreen(JPanel panel, int noOfPlaylists) {
		panel.removeAll();

		String[] names = new String[noOfPlaylists];
		int[] lengths = new int[noOfPlaylists];
		int sum = 0;
		for (int i = 0; i < noOfPlaylists; i++) {
			final int index = i;

			final JLabel title1 = new JLabel("Enter the name of playlist " + (i + 1));
			final JTextField name = new JTextField();
			panel.add(title1);
			panel.add(name);

			name.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					names[index] = name.getText();
				}
			});

			final JLabel title2 = new JLabel("Enter the length of playlist " + (i + 1));
			final JTextField length = new JTextField();
			panel.add(title2);
			panel.add(length);

			length.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int len = 0;
					try {
						len = Integer.parseInt(length.getText());
					} catch (NumberFormatException ex) {
						final JLabel error = new JLabel("Invalid input!");
						panel.add(error);
					}

					lengths[index] = len;
				}
			});

			if (lengths[i] > 0) {
				sum += lengths[i];
			}

			panel.revalidate();
			panel.repaint();
		}

		final int summ = sum;

		panel.removeAll();
		JButton submit = new JButton("Not quick enough, can I have it quicker?");
		submit.setBounds(180, 160, 200, 30);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canIhaveAword(panel, names, lengths, summ, noOfPlaylists);
			}
		});

		panel.add(submit);
		panel.revalidate();
		panel.repaint();
	}

	public static void canIhaveAword(JPanel panel, String[] names, int lengths[], int sum, int noOfPlaylists) {
		panel.removeAll();

		double edward = (double) sum / noOfPlaylists;
		double minDiff = Math.abs (edward - lengths[0]);
		String winner = names[0];
		
		for (int i = 1; i < noOfPlaylists; i++) {
			double currDiff = Math.abs (edward - lengths[i]);
			if (currDiff < minDiff) {
				minDiff = currDiff;
				winner = names[i];
			}
		}
		
		final JLabel result = new JLabel("The winning playlist is " + winner);

		panel.add(result);
		panel.revalidate();
		panel.repaint();
	}
}