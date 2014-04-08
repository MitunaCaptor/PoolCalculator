import java.awt.*;
import javax.swing.*;


public class PoolCalculator extends JPanel
{
	
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) 
	{
		new PoolCalculator();
	}
	

	public PoolCalculator()
	{
		super ();
		
		JTabbedPane tab = new JTabbedPane();
		JLabel l1 = new JLabel("Welcome To The Official Pool Calculator. Please Choose The Proper Tab For your project.");
		JPanel p1 = new JPanel();
		p1.add(l1);
		tab.addTab("Tab#1", null, p1, "panel#1");
		
		
		JLabel l2 = new JLabel("Welcome to the JTabbedPaneDemo", SwingConstants.CENTER);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.blue);
		p2.add(l2);
		tab.addTab("Tab#2", null, p2, "Panel#2");
		
		
		JLabel l3 = new JLabel("Java is sooooooo much fun!");
		JPanel p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.add(new JButton("J"), BorderLayout.NORTH);
		p3.add(new JButton("A"), BorderLayout.WEST);
		p3.add(new JButton("V"), BorderLayout.EAST);
		p3.add(new JButton("A"), BorderLayout.SOUTH);
		p3.add(l3, BorderLayout.CENTER);
		tab.addTab("Tab#3", null, p3, "Panel#3");
		
		
		JLabel l4 = new JLabel("Panel Four");
		JPanel p4 = new JPanel();
		p4.setBackground(Color.black);
		JLabel digits = new JLabel("Java");
		digits.setFont(new Font("Serif",Font.ITALIC, 50));
		digits.setForeground(Color.blue);
		p4.add(digits);
		tab.addTab("Tab#4",null, p4, "Panel#4");
		
		
		JLabel l5 = new JLabel("Panel Five");
		JLabel l6 = new JLabel("The end");
		JPanel p5 = new JPanel();
		p5.add(l6);
		tab.addTab("Tab#5", null, p5, "Panel#5");
		
		
		getContentPane().add(tab);
		
		setSize(550, 250);
		setVisible(true);
	}



}
