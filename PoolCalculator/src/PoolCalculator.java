
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.*;


public class PoolCalculator extends JPanel
{
	
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) 
	{
		new PoolCalculator();
	}
	private JFrame mainFrame;
	
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

	public PoolCalculator()
	{
		mainFrame = new JFrame();
		
		poolWidthLabel = new JLabel(" Enter the width of the swimming pool ");
		poolLengthLabel = new JLabel(" Enter the height of the swimming pool ");
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
		add(WidthInput);
		
		add(poolLengthLabel);
		add(LengthInput);
		
		add(poolDepthLabel);
		add(DepthInput);
		
		add(poolVolumeLabel);
		add(VolumeInput);
		
		add(CalculateVolButton);
		add(ExitButton);
		
		CalculateVolButton.setMnemonic('C'); 
		ExitButton.setMnemonic('X');
		
		
		mainFrame.addWindowListener(new WindowAdapter()
        {
          public void windowClosing(WindowEvent e) {System.exit(0);}
        });
		
		
		CalculateButtonHandler cHandler = new CalculateButtonHandler(); 
        CalculateVolButton.addActionListener(chandler);

        ExitButtonHandler eHandler = new ExitButtonHandler(); 
        ExitButton.addActionListener(ehandler);     

        FocusHandler focusHandler = new FocusHandler();
        LengthInput.addFocusListener(focusHandler); 
        WidthInput.addFocusListener(focusHandler);
        DepthInput.addFocusListener(focusHandler);
        VolumeInput.addFocusListener(focusHandler);
        
		
		
	}
		
	class CalculateButtonHandler implements ActionListener 
	{
        public void actionPerformed(ActionEvent e)
        {
          DecimalFormat num = new DecimalFormat(",###.##");
          String input;      
          double length, width, depth, volume;

          LengthInput.setEnabled(true);       
          input = LengthInput.getText(); 
            
          if (input.equals(""))
          {
            input = "0";
            LengthInput.setText("0");
          }     
          length = Double.parseDouble(input);  
          input = WidthInput.getText();  
            
          if (input.equals(""))
          {
            input = "0";
            WidthInput.setText("0");
          }     
          width = Double.parseDouble(input); 
          input = DepthInput.getText(); 
          
          if (input.equals(""))
          {
            input = "0";
            DepthInput.setText("0");
          }     
          depth = Double.parseDouble(input);
          
          volume = length * width * depth;     
          VolumeInput.setText(num.format(volume));
        }
      }
		
	class ExitButtonHandler implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    } 	
	



}
