import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HotTubs extends JPanel {

	private static final long serialVersionUID = 1L;

	/*
	 * class OvalTub extends JRadioButton{
	 * 
	 * } class RoundTub extends JRadioButton{
	 * 
	 * }
	 */
	public static void main(String[] args) {
		new HotTubs();
	}

	private JLabel TubWidthLabel;
	private JLabel TubLengthLabel;
	private JLabel TubDepthLabel;
	private JLabel TubVolumeLabel;

	private JTextField WidthInput;
	private JTextField LengthInput;
	private JTextField DepthInput;
	private JTextField VolumeInput;

	private JButton CalculateVolButton;
	private JButton ExitButton;

	private JRadioButton RoundRadio;
	private JRadioButton OvalRadio;

	public HotTubs() {

		TubWidthLabel = new JLabel(" Enter the width of the Hot Tub ");
		TubLengthLabel = new JLabel(" Enter the length of the Hot Tub ");
		TubDepthLabel = new JLabel(" Enter the depth of the Hot Tub ");
		TubVolumeLabel = new JLabel(" The Volume of the Hot Tub is: ");
		CalculateVolButton = new JButton(" Calcuate ");
		ExitButton = new JButton(" Exit ");
		RoundRadio = new JRadioButton("Please Select Round Tub ");
		OvalRadio = new JRadioButton(" or an Oval Tub ");

		WidthInput = new JTextField(5);
		LengthInput = new JTextField(5);
		DepthInput = new JTextField(5);
		VolumeInput = new JTextField(10);

		ButtonGroup tb = new ButtonGroup();
		tb.add(RoundRadio);
		tb.add(OvalRadio);

		this.VolumeInput.setEditable(false);

		add(RoundRadio);
		add(OvalRadio);
		add(TubWidthLabel);
		add(WidthInput);

		add(TubLengthLabel);
		add(LengthInput);

		add(TubDepthLabel);
		add(DepthInput);

		add(CalculateVolButton);
		add(ExitButton);

		add(TubVolumeLabel);
		add(VolumeInput);

		RoundRadio.setMnemonic('R');
		OvalRadio.setMnemonic('O');
		CalculateVolButton.setMnemonic('C');
		ExitButton.setMnemonic('X');

		CalculateButtonHandler cHandler = new CalculateButtonHandler();
		CalculateVolButton.addActionListener(cHandler);

		ExitButtonHandler eHandler = new ExitButtonHandler();
		ExitButton.addActionListener(eHandler);

		FocusHandler focusHandler = new FocusHandler();
		LengthInput.addFocusListener(focusHandler);
		WidthInput.addFocusListener(focusHandler);
		DepthInput.addFocusListener(focusHandler);
		VolumeInput.addFocusListener(focusHandler);

	}

	/*
	 * Guys after many hrs. I'm totally stump on the radio button, the only
	 * thing I came up with was If (RoundButton.IsEnable()){...} else
	 * if(OvalButton.IsEnable()... which still wont work, thus I left at a code
	 * where the project will still run
	 */

	class CalculateButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DecimalFormat num = new DecimalFormat(",###.##");
			String input;
			double length, width, depth, volume;

			LengthInput.setEnabled(true);
			input = LengthInput.getText();
			if (input.equals("")) {
				input = "0";
				LengthInput.setText("0");
			}
			length = Double.parseDouble(input);

			WidthInput.setEnabled(true);
			input = WidthInput.getText();
			if (input.equals("")) {
				input = "0";
				WidthInput.setText("0");
			}
			width = Double.parseDouble(input);

			DepthInput.setEnabled(true);
			input = DepthInput.getText();
			if (input.equals("")) {
				input = "0";
				DepthInput.setText("0");
			}
			depth = Double.parseDouble(input);

			volume = length * width * depth;
			VolumeInput.setText(num.format(volume));

			try {

				FileWriter fileW = new FileWriter("Data.txt", true);
				System.out.println("Writing data to Data.txt file");
				fileW.write("Length:");
				fileW.write(LengthInput.getText());
				fileW.write(",");
				fileW.write(" ");
				fileW.write("Width:");
				fileW.write(WidthInput.getText());
				fileW.write(",");
				fileW.write(" ");
				fileW.write("Depth:");
				fileW.write(DepthInput.getText());
				fileW.write(",");
				fileW.write(" ");
				fileW.write("Volume:");
				fileW.write(VolumeInput.getText());
				fileW.write("\n");
				fileW.close();

				FileReader fileR = new FileReader("Data.txt");
				BufferedReader buffIn = new BufferedReader(fileR);
				String textData = buffIn.readLine();
				System.out.println(textData);
				buffIn.close();
				System.out.print("\n");
			} catch (IOException el) {
				JOptionPane
						.showMessageDialog(null, el.getMessage(), "ERROR", 2);
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
			if (e.getSource() == WidthInput) {
				WidthInput.setText(" ");
				VolumeInput.setText(" ");
			}

			else if (e.getSource() == LengthInput) {
				LengthInput.setText(" ");
				VolumeInput.setText(" ");
			}

			else if (e.getSource() == DepthInput) {
				DepthInput.setText(" ");
				VolumeInput.setText(" ");
			}
		}

		public void focusLost(FocusEvent e) {
			if (e.getSource() == WidthInput) {
				CalculateVolButton.setFocusable(true);
			}

			else if (e.getSource() == LengthInput) {
				CalculateVolButton.setFocusable(true);
			}

			else if (e.getSource() == DepthInput) {
				CalculateVolButton.setFocusable(true);
			}
		}

	}

}
