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
	private JComboBox<?> TypeIn;

	public TemperatureCalc() {

		EnterTemp = new JLabel(" Enter the temperature ");
		ResultLabel = new JLabel(" Result ");
		ConvertButton = new JButton(" Convert ");
		ExitButton = new JButton(" Exit ");
		TypeIn = new JComboBox<Object>(items);

		TempInput = new JTextField(10);
		ResultOutput = new JTextField(10);

		this.ResultOutput.setEditable(false);
		setLayout(null);
		
		add(EnterTemp);
		EnterTemp.setBounds( 250, 25, 260, 20 );
		add(TempInput);
		TempInput.setBounds( 500, 25, 70, 20 );
		add(TypeIn);
		TypeIn.setBounds( 600, 25, 50, 20 );

		add(ResultLabel);
		ResultLabel.setBounds( 250, 70, 260, 20 );
		add(ResultOutput);
		ResultOutput.setBounds( 500, 70, 70, 20 );

		add(ConvertButton);
		ConvertButton.setBounds( 250, 115, 100, 20 );
		add(ExitButton);
		ExitButton.setBounds( 500, 115, 100, 20 );

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
			
			double fahrenheit = 0, celcius = 0;

			TempInput.setEnabled(true);
			if(items[0] != null)
			{
				if (!TempInput.getText().equals(""))
				{
				fahrenheit = Double.parseDouble(TempInput.getText());
				celcius = (Double)(fahrenheit - 32)*(5)/(9);
				ResultOutput.setText(num.format(celcius));
				}
				else
				{
				ResultOutput.setText("0");
				}
			}
			else if(items[1] != null)
			{
				if (!TempInput.getText().equals(""))
				{
				celcius = Double.parseDouble(TempInput.getText());
				fahrenheit = (Double)(celcius) * (9) / (5) + 32;
				ResultOutput.setText(num.format(fahrenheit));
				}
				else
				{
				ResultOutput.setText("0");
				}
			}
			
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
				
			}

		}

	}

}
