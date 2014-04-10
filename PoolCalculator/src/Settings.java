
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.*;



public class Settings extends JPanel
{
	
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) 
	{
		new Settings();
	}
	
	
	private JPanel panelN, panelS, panelC;
	
	
	private JLabel CompanyNameLabel;
	
	private JTextField CompanyNameInput;
	
	private JButton ApplySettingsButton;
	private JButton ExitButton;

	public void Settings()
	{
		CompanyNameLabel = new JLabel("Enter Company Name: ");

		ApplySettingsButton = new JButton("Apply Settings");
		ExitButton = new JButton("Exit");
		
		CompanyNameInput = new JTextField(5);
		
		
		add(CompanyNameLabel);
		add(CompanyNameInput);
		
		add(ApplySettingsButton);
		add(ExitButton);
	}
	
}
