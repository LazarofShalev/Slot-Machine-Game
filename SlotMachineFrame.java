


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SlotMachineFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField wonLost;

	public SlotMachineFrame(int w, int h) {

		this.setSize(w, h);
		this.setLayout(new BorderLayout());

		SlotMachinePanel mainGamePanel = new SlotMachinePanel();
		this.add(mainGamePanel, BorderLayout.CENTER);
		
		wonLost = new JTextField();
		wonLost.setEditable(false);
		wonLost.setHorizontalAlignment(SwingConstants.CENTER);
		wonLost.setText("Click Play");
		wonLost.setBorder(null);
		wonLost.setPreferredSize(new Dimension(200, 30));
		this.add(wonLost, BorderLayout.SOUTH);
		
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainGamePanel.Play();
			}
		});
		
		this.add(playButton, BorderLayout.WEST);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void updateTheTextField(String theCall) {
		wonLost.setText(theCall);
	}
}
