import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class General extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel Message;
	private JLabel DateTime;

	private JLabel Info;

	public General() {
		Message = new JLabel("Current Date & Time: ");
		Message.setBounds(150,35,150,20);

		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		DateTime = new JLabel(date);
		DateTime.setBounds(350,35,150,20);

		Info = new JLabel("Welcome to Pool Caulcuator & Database Alpha |");

		add(Info);

		add(Message);
		add(DateTime);

	}

}
