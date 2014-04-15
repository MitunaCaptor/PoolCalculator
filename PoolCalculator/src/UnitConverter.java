import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UnitConverter extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;

	private JFrame frame;
	private JPanel content;

	private JLabel lblCentimeter, lblInch, lblMeter, lblFeet;
	private JTextField txtCentimeter, txtInch, txtMeter, txtFeet;
	private JButton btnConvert;
	private JTextField txtResult;

	public UnitConverter() // constructor
	{
		frame = new JFrame("Unit Converter");
		content = new JPanel();
		frame.add(content);

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

		content.setLayout(new GridLayout(5, 3));

		content.add(lblCentimeter);
		content.add(txtCentimeter);
		content.add(lblInch);
		content.add(txtInch);

		content.add(lblMeter);
		content.add(txtMeter);
		content.add(lblFeet);
		content.add(txtFeet);

		content.add(btnConvert);
		content.add(txtResult);

		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
