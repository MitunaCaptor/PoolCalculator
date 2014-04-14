
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.*;



public class Conversion extends JPanel
{
	
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

	public Conversion()
	{
		
		
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
		add(InchesInput);
		
		add(ImperialFeetLabel);
		add(FeetInput);
		
		add(ImperialYardsLabel);
		add(YardsInput);
		
		add(MetricMillimetersLabel);
		add(MillimetersInput);
		
		add(MetricCentimetersLabel);
		add(CentimetersInput);
		
		add(MetricMetersLabel);
		add(MetersInput);
		
		add(CalculateConversionButton);
		add(ExitButton);
		
		
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
		
	class CalculateButtonHandler implements ActionListener 
	{
        public void actionPerformed(ActionEvent e)
        {
          DecimalFormat num = new DecimalFormat(",###.##");
          String input;      
          double inches, feet, yards, millimeters, centimeters, meters;

          // begin imperial
          InchesInput.setEnabled(true);       
          input = InchesInput.getText();   
          if (input.equals(""))
          {
            input = "0";
            InchesInput.setText("0");
          }     
          inches = Double.parseDouble(input);
          
          FeetInput.setEnabled(true); 
          input = FeetInput.getText();   
          if (input.equals(""))
          {
            input = "0";
            FeetInput.setText("0");
          }     
          feet = Double.parseDouble(input);
          
          YardsInput.setEnabled(true); 
          input = YardsInput.getText(); 
          if (input.equals(""))
          {
            input = "0";
            YardsInput.setText("0");
          }     
          yards = Double.parseDouble(input);
          
          // begin metric
          MillimetersInput.setEnabled(true); 
          input = MillimetersInput.getText(); 
          if (input.equals(""))
          {
            input = "0";
            MillimetersInput.setText("0");
          }     
          millimeters = Double.parseDouble(input);
          
          CentimetersInput.setEnabled(true); 
          input = MillimetersInput.getText(); 
          if (input.equals(""))
          {
            input = "0";
            MillimetersInput.setText("0");
          }     
          centimeters = Double.parseDouble(input);
          
          MetersInput.setEnabled(true); 
          input = MetersInput.getText(); 
          if (input.equals(""))
          {
            input = "0";
            MetersInput.setText("0");
          }     
          meters = Double.parseDouble(input);
          
          
          meters = centimeters * 10;  
          centimeters = meters / 10;  
          millimeters = centimeters / 10;
          inches = feet / 12;
          feet = yards / 3;
          yards = feet * 3;
          
          InchesInput.setText(num.format(inches));
          YardsInput.setText(num.format(yards));
          FeetInput.setText(num.format(feet));
          MillimetersInput.setText(num.format(millimeters));
          CentimetersInput.setText(num.format(centimeters));
          MetersInput.setText(num.format(meters));
          
       
        }
      }
		
	class ExitButtonHandler implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    } 	
	
	class FocusHandler implements FocusListener
	{
		public void focusGained (FocusEvent e)
		{
			if(e.getSource() == InchesInput)
			{
				InchesInput.setText(" ");
			}
			
			else if(e.getSource() == FeetInput)
			{
				FeetInput.setText(" ");
			}
			
			else if(e.getSource() == YardsInput)
			{
				YardsInput.setText(" ");
			}
			
			else if(e.getSource() == MillimetersInput)
			{
				MillimetersInput.setText(" ");
			}
			
			else if(e.getSource() == CentimetersInput)
			{
				CentimetersInput.setText(" ");
			}
			
			else if(e.getSource() == MetersInput)
			{
				MetersInput.setText(" ");
			}
		}
		
		public void focusLost(FocusEvent e)
		{
			if (e.getSource() == InchesInput)
			{
				CalculateConversionButton.setFocusable(true);
			}
			
			else if (e.getSource() == FeetInput)
			{
				CalculateConversionButton.setFocusable(true);
			}
			
			else if (e.getSource() == YardsInput)
			{
				CalculateConversionButton.setFocusable(true);
			}
			
			else if (e.getSource() == MillimetersInput)
			{
				CalculateConversionButton.setFocusable(true);
			}
			
			else if (e.getSource() == CentimetersInput)
			{
				CalculateConversionButton.setFocusable(true);
			}
			
			else if (e.getSource() == MetersInput)
			{
				CalculateConversionButton.setFocusable(true);
			}
		}
		
	}


}
