import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class headerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Create the panel.
	 */
	public headerPanel() {
		
		JLabel headerLabel = new JLabel("");
		headerLabel.setIcon(new ImageIcon("C:\\Users\\Dave\\eclipse-workspace\\Assignment3_B00107874\\src\\itb_logo.gif"));
		add(headerLabel);
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

	}

}
