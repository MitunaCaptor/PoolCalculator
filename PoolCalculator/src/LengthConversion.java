import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LengthConversion extends JPanel {

	private static final long serialVersionUID = 3L;

	private JLabel ImperialInchesLabel;
	private JLabel ImperialFeetLabel;
	private JLabel ImperialYardsLabel;
	private JLabel MetricMillimetersLabel;
	private JLabel MetricCentimetersLabel;
	private JLabel MetricMetersLabel;

	private JTextField InchesInput;
	private JTextField FeetInput;
	private JTextField YardsInput;
	private JTextField MillimetersInput;
	private JTextField CentimetersInput;
	private JTextField MetersInput;

	private JButton CalculateConversionButton;
	private JButton ExitButton;

	public LengthConversion() {

		setLayout(null);

		ImperialInchesLabel = new JLabel("Enter Inches: ");
		ImperialFeetLabel = new JLabel("Enter Feet: ");
		ImperialYardsLabel = new JLabel("Enter Yards: ");
		MetricMillimetersLabel = new JLabel("Enter Millimeters: ");
		MetricCentimetersLabel = new JLabel("Enter Centimeters: ");
		MetricMetersLabel = new JLabel("Enter Meters: ");

		CalculateConversionButton = new JButton("Calculate");
		ExitButton = new JButton("Exit");

		InchesInput = new JTextField(10);
		FeetInput = new JTextField(10);
		YardsInput = new JTextField(10);
		MillimetersInput = new JTextField(10);
		CentimetersInput = new JTextField(10);
		MetersInput = new JTextField(10);

		add(ImperialInchesLabel);
		ImperialInchesLabel.setBounds(200, 20, 260, 20);
		add(InchesInput);
		InchesInput.setBounds(500, 20, 150, 20);

		add(ImperialFeetLabel);
		ImperialFeetLabel.setBounds(200, 40, 260, 20);
		add(FeetInput);
		FeetInput.setBounds(500, 40, 150, 20);

		add(ImperialYardsLabel);
		ImperialYardsLabel.setBounds(200, 60, 260, 20);
		add(YardsInput);
		YardsInput.setBounds(500, 60, 150, 20);

		add(MetricMillimetersLabel);
		MetricMillimetersLabel.setBounds(200, 80, 260, 20);
		add(MillimetersInput);
		MillimetersInput.setBounds(500, 80, 150, 20);

		add(MetricCentimetersLabel);
		MetricCentimetersLabel.setBounds(200, 100, 260, 20);
		add(CentimetersInput);
		CentimetersInput.setBounds(500, 100, 150, 20);

		add(MetricMetersLabel);
		MetricMetersLabel.setBounds(200, 120, 260, 20);
		add(MetersInput);
		MetersInput.setBounds(500, 120, 150, 20);

		add(CalculateConversionButton);
		CalculateConversionButton.setBounds(200, 140, 260, 20);
		add(ExitButton);
		ExitButton.setBounds(500, 140, 150, 20);

		CalculateConversionButton.setMnemonic('C');
		ExitButton.setMnemonic('X');

		CalculateButtonHandler cHandler = new CalculateButtonHandler();
		CalculateConversionButton.addActionListener(cHandler);

		ExitButtonHandler eHandler = new ExitButtonHandler();
		ExitButton.addActionListener(eHandler);

		FocusHandler focusHandler = new FocusHandler();
		InchesInput.addFocusListener(focusHandler);
		FeetInput.addFocusListener(focusHandler);
		YardsInput.addFocusListener(focusHandler);
		MillimetersInput.addFocusListener(focusHandler);
		CentimetersInput.addFocusListener(focusHandler);
		MetersInput.addFocusListener(focusHandler);

	}

	class CalculateButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DecimalFormat num = new DecimalFormat(",###.##");
			String input;
			double inches, feet, yards, millimeters, centimeters, meters;

			// begin imperial
			InchesInput.setEnabled(true);
			input = InchesInput.getText();
			if (input.equals("")) {
				input = "0";
				InchesInput.setText("0");
			}
			inches = Double.parseDouble(input);

			FeetInput.setEnabled(true);
			input = FeetInput.getText();
			if (input.equals("")) {
				input = "0";
				FeetInput.setText("0");
			}
			feet = Double.parseDouble(input);

			YardsInput.setEnabled(true);
			input = YardsInput.getText();
			if (input.equals("")) {
				input = "0";
				YardsInput.setText("0");
			}
			yards = Double.parseDouble(input);

			// begin metric
			MillimetersInput.setEnabled(true);
			input = MillimetersInput.getText();
			if (input.equals("")) {
				input = "0";
				MillimetersInput.setText("0");
			}
			millimeters = Double.parseDouble(input);

			CentimetersInput.setEnabled(true);
			input = MillimetersInput.getText();
			if (input.equals("")) {
				input = "0";
				MillimetersInput.setText("0");
			}
			centimeters = Double.parseDouble(input);

			MetersInput.setEnabled(true);
			input = MetersInput.getText();
			if (input.equals("")) {
				input = "0";
				MetersInput.setText("0");
			}
			meters = Double.parseDouble(input);

			if (inches > 0) // calculate inches
			{
				feet = 0;
				yards = 0;
				millimeters = 0;
				centimeters = 0;
				meters = 0;

				meters = centimeters * 10;
				centimeters = meters / 10;
				millimeters = centimeters / 10;
				inches = feet / 12;
				feet = yards / 3;
				yards = feet * 3;
			}
			if (feet > 0) // calculate feet
			{
				inches = 0;
				yards = 0;
				millimeters = 0;
				centimeters = 0;
				meters = feet * 0;
			}
			if (yards > 0) // calculate yards
			{
				inches = 0;
				feet = 0;
				millimeters = 0;
				centimeters = 0;
				meters = 0;
			}
			if (millimeters > 0) // calculate millimeters
			{
				inches = 0;
				feet = 0;
				yards = 0;
				centimeters = 0;
				meters = 0;
			}
			if (centimeters > 0) // calculate centimeters
			{
				inches = 0;
				feet = 0;
				yards = 0;
				millimeters = 0;
				meters = 0;
			}
			if (meters > 0) // calculate meters
			{
				inches = 0;
				feet = 0;
				yards = 0;
				millimeters = 0;
				centimeters = 0;
			}

			InchesInput.setText(num.format(inches));
			YardsInput.setText(num.format(yards));
			FeetInput.setText(num.format(feet));
			MillimetersInput.setText(num.format(millimeters));
			CentimetersInput.setText(num.format(centimeters));
			MetersInput.setText(num.format(meters));

		}
	}

	class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class FocusHandler implements FocusListener {
		public void focusGained(FocusEvent e) {
			if (e.getSource() == InchesInput) {
				InchesInput.setText(" ");
			}

			else if (e.getSource() == FeetInput) {
				FeetInput.setText(" ");
			}

			else if (e.getSource() == YardsInput) {
				YardsInput.setText(" ");
			}

			else if (e.getSource() == MillimetersInput) {
				MillimetersInput.setText(" ");
			}

			else if (e.getSource() == CentimetersInput) {
				CentimetersInput.setText(" ");
			}

			else if (e.getSource() == MetersInput) {
				MetersInput.setText(" ");
			}
		}

		public void focusLost(FocusEvent e) {
			if (e.getSource() == InchesInput) {
				CalculateConversionButton.setFocusable(true);
			}

			else if (e.getSource() == FeetInput) {
				CalculateConversionButton.setFocusable(true);
			}

			else if (e.getSource() == YardsInput) {
				CalculateConversionButton.setFocusable(true);
			}

			else if (e.getSource() == MillimetersInput) {
				CalculateConversionButton.setFocusable(true);
			}

			else if (e.getSource() == CentimetersInput) {
				CalculateConversionButton.setFocusable(true);
			}

			else if (e.getSource() == MetersInput) {
				CalculateConversionButton.setFocusable(true);
			}
		}

	}

}