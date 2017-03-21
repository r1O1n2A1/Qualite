package fr.afcepf.al30.qualimetrie.data;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * @author ronan
 *
 */
/**
 * @author ronan
 *
 */
public class DSQualite implements DataSource {
	private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(DSQualite.class);
	/**
	 * JNDI path to persistence -  unit
	 */
	private static String url;
	/**
	 * mdp
	 */
	private static String mdp;
	/**
	 * login
	 */
	private static String login;
	/**
	 * initialisation connection a partir
	 * du fichier de properties
	 */
	static {
		ResourceBundle rb = ResourceBundle.getBundle("bdd");
		url = rb.getString("url");
		login = rb.getString("login");
		mdp = rb.getString("mdp");
		try {
			Class.forName(rb.getString("driver"));
		} catch (ClassNotFoundException excep) {
			logger.error(excep.getMessage());
		}
	}
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, login, mdp);
	}

	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

}
