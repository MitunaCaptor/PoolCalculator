import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

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

	private JButton Calculate;
	private JButton Exit;
	
	private JLabel poolWidthLabel;
	private JLabel poolLengthLabel;
	private JLabel poolDepthLabel;
	private JLabel poolVolumeLabel;

	private JTextField WidthInput;
	private JTextField LengthInput;
	private JTextField DepthInput;
	private JTextField VolumeInput;
	
	private JRadioButton rdbtnRoundTub;
	private JRadioButton rdbtnOvalTub;

	public HotTubs() {

		setLayout(null);
		
		rdbtnRoundTub = new JRadioButton("RoundTub"); 
		rdbtnRoundTub.setSelected(true);  
		rdbtnRoundTub.setBounds(250, 7, 109, 23);
		add(rdbtnRoundTub);
		
		rdbtnOvalTub = new JRadioButton("Oval Tub"); 
		rdbtnOvalTub.setSelected(true);  
		rdbtnOvalTub.setBounds(500, 7, 109, 23);
		add(rdbtnOvalTub);
		
		rdbtnRoundTub.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0){ 
				WidthInput.setEditable(false); 
			}});
		
		  
		rdbtnOvalTub.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0){ 
				WidthInput.setEditable(true); 
			}});
		
		ButtonGroup radioBtnGroup = new ButtonGroup();
		radioBtnGroup.add(rdbtnRoundTub);
		radioBtnGroup.add(rdbtnOvalTub);

		poolWidthLabel = new JLabel(" Enter the width of the swimming pool (ft)");
		poolLengthLabel = new JLabel(" Enter the length of the swimming pool (ft)");
		poolDepthLabel = new JLabel(" Enter the depth of the swimming pool (ft)");
		poolVolumeLabel = new JLabel(" Swimming pool volume (ft)");
		WidthInput = new JTextField(10);
		LengthInput = new JTextField(10);
		DepthInput = new JTextField(10);
		VolumeInput = new JTextField(10);
		
		this.VolumeInput.setEditable(false);
		
		add(poolWidthLabel);
		poolWidthLabel.setBounds( 250, 60, 260, 20 );
		add(WidthInput);
		WidthInput.setBounds( 500, 60, 50, 20 );

		add(poolLengthLabel);
		poolLengthLabel.setBounds( 250, 100, 260, 20 );
		add(LengthInput);
		LengthInput.setBounds( 500, 100, 50, 20 );

		add(poolDepthLabel);
		poolDepthLabel.setBounds( 250, 140, 260, 20 );
		add(DepthInput);
		DepthInput.setBounds( 500, 140, 50, 20 );

		
		Calculate = new JButton("Calculate");
		Calculate.setMnemonic('C');
		add(Calculate);
		Calculate.setBounds(250, 200, 109, 23);
		
		
		Exit = new JButton("Exit");
		Exit.setMnemonic('X');
		add(Exit);
		Exit.setBounds(500, 200, 109, 23);
		
		add(poolVolumeLabel);
		poolVolumeLabel.setBounds(250,250,260,20);
		add(VolumeInput);
		VolumeInput.setBounds(500,250,50,20);
		
		CalculateButtonHandler cHandler = new CalculateButtonHandler();
		Calculate.addActionListener(cHandler);

		ExitButtonHandler eHandler = new ExitButtonHandler();
		Exit.addActionListener(eHandler);
		
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
			
			if(rdbtnRoundTub.isSelected()) 
			{
				volume = length / (2.0) * depth;
				VolumeInput.setText(num.format(volume));
			}
			else
			{
			volume = length * width * depth;
			VolumeInput.setText(num.format(volume));
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
				Calculate.setFocusable(true);
			}

			else if (e.getSource() == LengthInput) {
				Calculate.setFocusable(true);
			}

			else if (e.getSource() == DepthInput) {
				Calculate.setFocusable(true);
			}
		}

	}

}
