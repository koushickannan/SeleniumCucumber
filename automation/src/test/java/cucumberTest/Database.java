package cucumberTest;

import java.sql.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Database {

	final static Logger logger = Logger.getLogger(Database.class);
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	String host;
	String port;
	String login;
	String password;
	String connectionurl;
	String db;

	public Database(String login, String password, String db, String host, String port, String url) {
		logger.info("Database Connection Method Called");
		this.login = login;
		this.password = password;
		this.host = host;
		this.port = port;
		this.db = db;

		connectionurl = url + host + ":" + port + "/" + db;
		logger.info("Constructed Connection URL for the Database" + connectionurl);
		Connect();
	}

	private void Connect() {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("JDBC Connection establisment initiated");
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
		try {
			connection = DriverManager.getConnection(connectionurl, login, password);
			statement = connection.createStatement();
			logger.info("Connection Established");
		}

		catch (SQLException e) {
			logger.error("Connection to the Database Failed\n" + e);
		}
	}

	public ResultSet Query(String query) {

		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
		} catch (Exception e) {
			logger.error("Exception occured:\n" + e.getMessage());
		}
		return resultset;
	}

	public void closeConnection() {

		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
			logger.error("Closing Execption\n" + e);
		}

	}

}
