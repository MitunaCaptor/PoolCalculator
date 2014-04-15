import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class HotTubs extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton cmdCalculate;
	private JButton cmdExit;

	public HotTubs() {

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

		add(cmdCalculate);
		add(cmdExit);
	}

}
