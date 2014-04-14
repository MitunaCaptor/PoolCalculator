import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperatureCalc extends JPanel

{

	private static final long serialVersionUID = 1L;

	private JLabel EnterTemp;
	private JLabel ResultLabel;

	private JTextField TempInput;
	private JTextField ResultOutput;

	private JButton ExitButton;
	private JButton ConvertButton;

	private String[] items = { "F", "C" };
	private JComboBox TypeIn = new JComboBox(items);

	public TemperatureCalc() {

		EnterTemp = new JLabel(" Enter the temperature ");
		ResultLabel = new JLabel(" Result ");
		ConvertButton = new JButton(" Convert ");
		ExitButton = new JButton(" Exit ");

		TempInput = new JTextField(5);
		ResultOutput = new JTextField(10);

		this.ResultOutput.setEditable(false);

		add(EnterTemp);
		add(TempInput);
		add(TypeIn);

		add(ResultLabel);
		add(ResultOutput);

		add(ConvertButton);
		add(ExitButton);

		ConvertButton.setMnemonic('C');
		ExitButton.setMnemonic('X');

		ConvertButtonHandler cHandler = new ConvertButtonHandler();
		ConvertButton.addActionListener(cHandler);

		ExitButtonHandler eHandler = new ExitButtonHandler();
		ExitButton.addActionListener(eHandler);

		FocusHandler focusHandler = new FocusHandler();
		TempInput.addFocusListener(focusHandler);

	}

	class ConvertButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DecimalFormat num = new DecimalFormat(",###.##");
			String input;
			double fahrenheit, celcius;

			TempInput.setEnabled(true);

			input = TempInput.getText();
			// if(TypeIn.getSelectedIndex() == 0)
			if (input.equals("")) {
				input = "0";
				TempInput.setText("0");
			}
			fahrenheit = Double.parseDouble(input);
			celcius = (fahrenheit - 32) * (5 / 9);
			ResultOutput.setText(num.format(celcius));

			/*
			 * if(TypeIn.getSelectedIndex() == 1) if (input.equals("")) { input
			 * = "0"; TempInput.setText("0"); } else { celcius =
			 * Double.parseDouble(input); fahrenheit = celcius * (9 / 5) + 32;
			 * ResultOutput.setText(num.format(fahrenheit)); }
			 */

		}
	}

	class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class FocusHandler implements FocusListener {
		public void focusGained(FocusEvent e) {
			if (e.getSource() == TempInput) {
				TempInput.setText("");
				ResultOutput.setText("");
			}

		}

		public void focusLost(FocusEvent e) {
			if (e.getSource() == TempInput) {
				ConvertButton.setFocusable(true);
				;
			}

		}

	}

}
