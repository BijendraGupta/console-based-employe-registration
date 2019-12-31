/**
 * 
 */
package console.based.employee.registration.application.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Bijendra
 *
 */
public class MySqlJDBC {

	private static Connection mySqlJDBC;

	
	public static Connection getMySqlJDBC() {
		if (mySqlJDBC == null) {
			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			mySqlJDBC = connection;
		}
		return mySqlJDBC;
	}

}
