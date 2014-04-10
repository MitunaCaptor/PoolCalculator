import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class GroupProject extends JFrame
{

	private static final long serialVersionUID = 1L;
	
	public GroupProject() 
	{
		setTitle("Group Project");
		setLayout(new BorderLayout());
		JTabbedPane gui2 = new JTabbedPane();
		getContentPane().add(gui2);
		
		gui2.addTab("Swimming Pool", new PoolCalculator());
		gui2.addTab("Hot Tubs", new HotTubs());
		gui2.addTab("Conversion", new Conversion());
		gui2.addTab("Settings", new Settings());
		
		
		//gui2.addTab();
		//gui2.addTab();
		//gui2.addTab();
		
		
		getContentPane().add(gui2);
		setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		    
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);
		
	}
	
	public static void main(String[] args) 
	{
		GroupProject tab2 = new GroupProject();
		new PoolCalculator();
		new HotTubs();
		new Conversion();
		new Settings();
		Settings.setTitle();
		
		tab2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
