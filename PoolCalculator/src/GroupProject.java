import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class GroupProject extends JFrame {

	private static final long serialVersionUID = 1L;

	public GroupProject() {
		setTitle("Group Project");
		setLayout(new GridLayout(0, 1));
		JTabbedPane gui2 = new JTabbedPane();
		getContentPane().add(gui2);

		gui2.addTab("General", new General());
		gui2.addTab("Pool Calculator", new PoolCalculator());
		gui2.addTab("Hot Tubs", new HotTubs());
		gui2.addTab("Length Convert", new LengthConversion());
		gui2.addTab("Unit Convert", new UnitConverter());
		gui2.addTab("Temp Convert", new TemperatureCalc());
		gui2.addTab("Customers", new Customers());
		gui2.addTab("Settings", new Settings());

		getContentPane().add(gui2);
		setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);

	}

	public static void main(String[] args) {
		GroupProject tab2 = new GroupProject();
		new General();
		new PoolCalculator();
		new HotTubs();
		new LengthConversion();
		new UnitConverter();
		new TemperatureCalc();
		new Settings();
		new Customers();

		tab2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
