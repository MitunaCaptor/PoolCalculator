
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PoolCalculator extends JPanel {

	private static final long serialVersionUID = 2L;


	private JLabel poolWidthLabel;
	private JLabel poolLengthLabel;
	private JLabel poolDepthLabel;
	private JLabel poolVolumeLabel;

	private JTextField WidthInput;
	private JTextField LengthInput;
	private JTextField DepthInput;
	private JTextField VolumeInput;

	private JButton CalculateVolButton;
	private JButton ExitButton;

	public PoolCalculator() {

		setLayout(null);

		poolWidthLabel = new JLabel(" Enter the width of the swimming pool ");
		poolLengthLabel = new JLabel(" Enter the length of the swimming pool ");
		poolDepthLabel = new JLabel(" Enter the depth of the swimming pool ");
		poolVolumeLabel = new JLabel(" Swimming pool volume ");
		CalculateVolButton = new JButton(" Calcuate ");
		ExitButton = new JButton(" Exit ");

		WidthInput = new JTextField(5);
		LengthInput = new JTextField(5);
		DepthInput = new JTextField(5);
		VolumeInput = new JTextField(10);

		this.VolumeInput.setEditable(false);

		add(poolWidthLabel);
		poolWidthLabel.setBounds( 200, 25, 260, 20 );
		add(WidthInput);
		WidthInput.setBounds( 500, 25, 150, 20 );

		add(poolLengthLabel);
		poolLengthLabel.setBounds( 200, 60, 260, 20 );
		add(LengthInput);
		LengthInput.setBounds( 500, 60, 150, 20 );

		add(poolDepthLabel);
		poolDepthLabel.setBounds( 200, 100, 260, 20 );
		add(DepthInput);
		DepthInput.setBounds( 500, 100, 150, 20 );

		add(CalculateVolButton);
		CalculateVolButton.setBounds(250,250,150,20);
		add(ExitButton);
		ExitButton.setBounds(450,250,150,20);

		add(poolVolumeLabel);
		poolVolumeLabel.setBounds(200,300,150,20);
		add(VolumeInput);
		VolumeInput.setBounds(500,300,150,20);
		
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
