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

		setLayout(null);

		add(ImperialInchesLabel);
		ImperialInchesLabel.setBounds(250, 25, 260, 20);
		add(InchesInput);
		InchesInput.setBounds(500, 25, 150, 20);

		add(ImperialFeetLabel);
		ImperialFeetLabel.setBounds(250, 60, 260, 20);
		add(FeetInput);
		FeetInput.setBounds(500, 60, 150, 20);

		add(ImperialYardsLabel);
		ImperialYardsLabel.setBounds(250, 95, 260, 20);
		add(YardsInput);
		YardsInput.setBounds(500, 95, 150, 20);

		add(MetricMillimetersLabel);
		MetricMillimetersLabel.setBounds(250, 130, 260, 20);
		add(MillimetersInput);
		MillimetersInput.setBounds(500, 130, 150, 20);

		add(MetricCentimetersLabel);
		MetricCentimetersLabel.setBounds(250, 165, 260, 20);
		add(CentimetersInput);
		CentimetersInput.setBounds(500, 165, 150, 20);

		add(MetricMetersLabel);
		MetricMetersLabel.setBounds(250, 200, 260, 20);
		add(MetersInput);
		MetersInput.setBounds(500, 200, 150, 20);

		add(CalculateConversionButton);
		CalculateConversionButton.setBounds(250, 235, 150, 20);
		add(ExitButton);
		ExitButton.setBounds(500, 235, 150, 20);

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
			// String input;
			double inches = 0, feet = 0, yards = 0, millimeters = 0, centimeters = 0, meters = 0;

			if (e.getSource() == InchesInput) {
				InchesInput.setEditable(true);
			} else if (e.getSource() == FeetInput) {
				FeetInput.setEditable(true);
			} else if (e.getSource() == YardsInput) {
				YardsInput.setEditable(true);
			} else if (e.getSource() == MillimetersInput) {
				MillimetersInput.setEditable(true);
			} else if (e.getSource() == CentimetersInput) {
				CentimetersInput.setEditable(true);
			} else if (e.getSource() == MetersInput) {
				MetersInput.setEditable(true);
			}

			if (!InchesInput.getText().equals("")) {
				inches = Double.parseDouble(InchesInput.getText());
				feet = inches / 12;
				yards = inches / 36;
				millimeters = inches / .03937;
				centimeters = inches * 2.54;
				meters = inches * .0254;
			}
			if (!YardsInput.getText().equals("")) {
				yards = Double.parseDouble(YardsInput.getText());
				feet = yards * 3;
				inches = yards * 36;
				millimeters = yards * 914.4;
				centimeters = yards / .010936;
				meters = yards * .9144;

			}
			if (!FeetInput.getText().equals("")) {
				feet = Double.parseDouble(FeetInput.getText());
				yards = feet / 3;
				inches = feet * 12;
				millimeters = feet / 304.8;
				centimeters = feet / 30.48;
				meters = feet / 3.281;

			}
			if (!MillimetersInput.getText().equals("")) {
				millimeters = Double.parseDouble(MillimetersInput.getText());
				yards = millimeters / 914.4;
				inches = millimeters / 25.4;
				feet = millimeters / 304.8;
				centimeters = millimeters / 10;
				meters = millimeters / 1000;
			}
			if (!CentimetersInput.getText().equals("")) {
				centimeters = Double.parseDouble(CentimetersInput.getText());
				yards = centimeters * .010936;
				inches = centimeters / .039370;
				feet = centimeters * .032808;
				millimeters = centimeters / .1;
				meters = centimeters / 100;
			}
			if (!MetersInput.getText().equals("")) {
				meters = Double.parseDouble(MetersInput.getText());
				yards = meters * 1.0936;
				inches = meters * 39.370;
				feet = meters * 3.2808;
				millimeters = meters / .001;
				centimeters = meters / .01;
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
