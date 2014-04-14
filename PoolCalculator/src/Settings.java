import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Settings extends JPanel {

	private static final long serialVersionUID = 1L;


	private JLabel CompanyNameLabel;

	private JTextField CompanyNameInput;

	private JButton ApplySettingsButton;
	private JButton ExitButton;

	public Settings() {
		CompanyNameLabel = new JLabel("Enter Company Name: ");

		ApplySettingsButton = new JButton("Apply Settings");
		ExitButton = new JButton("Exit");

		CompanyNameInput = new JTextField(5);

		add(CompanyNameLabel);
		add(CompanyNameInput);

		add(ApplySettingsButton);
		add(ExitButton);

		ApplySettingsButtonHandler cHandler = new ApplySettingsButtonHandler();
		ApplySettingsButton.addActionListener(cHandler);
	}

	class ApplySettingsButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input;
			CompanyNameInput.setEnabled(true);
			input = CompanyNameInput.getText();
			if (input.equals("")) {
				input = "N/A";
				CompanyNameInput.setText("N/A");
			}

		}
	}

}
