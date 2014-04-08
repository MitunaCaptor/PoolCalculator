import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;


public class HotTubs extends JPanel
{

	private static final long serialVersionUID = 1L;

	public static void initializeHotTubs() {
		
		JFrame frame = new JFrame("Lister v1.0");
		
		JPanel hotTubPanel = new JPanel();
		final ButtonGroup hotTubGroup = new ButtonGroup();
		JRadioButton radioButton;
		hotTubPanel.add(radioButton = new JRadioButton("Hot Tub"));
		radioButton.setActionCommand("Hot Tub");
		hotTubGroup.add(radioButton);
		hotTubPanel.add(radioButton = new JRadioButton("Oval Tub"));
		radioButton.setActionCommand("Oval Tub");
		hotTubGroup.add(radioButton);
		
		
		Container content = frame.getContentPane();
		content.setLayout(new GridLayout(3, 1));
		content.add(hotTubPanel);
		
		
		

	}

}
