import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UnitConverter extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblCentimeter, lblInch, lblMeter, lblFeet;
	private JTextField txtCentimeter, txtInch, txtMeter, txtFeet;
	private JButton btnConvert;
	private JTextField txtResult;

	public UnitConverter() // constructor
	{

		lblCentimeter = new JLabel("Centimeter");
		lblInch = new JLabel("Inch");
		lblMeter = new JLabel("Meter");
		lblFeet = new JLabel("Feet");

		txtCentimeter = new JTextField(7);
		txtInch = new JTextField(7);
		txtMeter = new JTextField(7);
		txtFeet = new JTextField(7);

		btnConvert = new JButton("Convert");

		txtResult = new JTextField(10);
		txtResult.setEditable(false);

		setLayout(new GridLayout(5, 3));

		add(lblCentimeter);
		add(txtCentimeter);
		add(lblInch);
		add(txtInch);

		add(lblMeter);
		add(txtMeter);
		add(lblFeet);
		add(txtFeet);

		add(btnConvert);
		add(txtResult);

	}
}
