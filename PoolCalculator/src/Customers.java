import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JTable;

public class Customers extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

		String[] columnNames = { "RecordID", "Name", "Address", "City",
				"State", "ZIP", "Phone" };

		Object[][] data = { { "000", "PERSON NAME", "ADDRESS", new Integer(5),
				new Boolean(false) } };

		JTable table = new JTable(data, columnNames);

		// buttons

		// message area
	}

	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://" + this.serverName
				+ ":" + this.portNumber + "/" + this.dbName, connectionProps);

		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException
	 *             If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command)
			throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it
											// fails
			return true;
		} finally {

			// This will run whether we throw an exception or not
			if (stmt != null) {
				stmt.close();
			}
		}
	}

}
