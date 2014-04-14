import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JPanel;

public class Customers extends JPanel {

	private final String userName = "foxly_cis";
	private final String password = "professorliu";
	private final String serverName = "198.251.76.197";
	private final int portNumber = 3306;
	private final String dbName = "foxly_cis";
	/** The name of the table we are testing with */
	private final String tableName = "CustomerDatabase";

	/*
	 * CREATE TABLE CustomerDatabase ( RecordID NUMERIC(5), Name VARCHAR(64),
	 * Address VARCHAR(64), City VARCHAR(32), State VARCHAR(2), ZIP NUMERIC(5),
	 * Phone NUMERIC(10), RID int(11) NOT NULL auto_increment, primary KEY
	 * (RID));
	 * 
	 * for changes use DROP TABLE CustomerDatabase;
	 */

	public Customers() {
		// customer list display

		// buttons

		// message area
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://" + this.serverName
				+ ":" + this.portNumber + "/" + this.dbName, connectionProps);

		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
