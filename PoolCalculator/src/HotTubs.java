import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class HotTubs extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton cmdCalculate;
	private JButton cmdExit;
	private JFrame mainFrame;

	public HotTubs() {

		mainFrame = new JFrame();

		ButtonGroup hotTubGroup = new ButtonGroup();

		JRadioButton radioButton;

		add(radioButton = new JRadioButton("Hot Tub"));
		radioButton.setActionCommand("Hot Tub");
		hotTubGroup.add(radioButton);

		add(radioButton = new JRadioButton("Oval Tub"));
		radioButton.setActionCommand("Oval Tub");
		hotTubGroup.add(radioButton);

		cmdCalculate = new JButton("Calculate");
		cmdExit = new JButton("Exit");
		mainFrame = new JFrame();

		add(cmdCalculate);
		add(cmdExit);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// mainFrame = new JFrame("CIS355A Week5 Example Project");
		// cmdGood = new JButton("Good");
		// cmdBad = new JButton("Bad");
		//
		// Container c = mainFrame.getContentPane();
		// c.setLayout(new FlowLayout());
		//
		// c.add(cmdGood);
		// c.add(cmdBad);
		//
		// cmdGood.setMnemonic('G');
		// cmdBad.setMnemonic('B');
		// mainFrame.setSize(300, 200);
		//
		// mainFrame.addWindowListener(new WindowAdapter()

		// Container content = frame.getContentPane();
		// content.setLayout(new GridLayout(3, 1));
		// content.add(hotTubPanel);
		//

	}

}
