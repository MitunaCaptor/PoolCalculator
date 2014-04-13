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

		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date());
		DateTime = new JLabel(date);

		Info = new JLabel("Welcome to Pool Caulcuator & Database Alpha |");

		add(Info);

		add(Message);
		add(DateTime);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new General();
	}

}
