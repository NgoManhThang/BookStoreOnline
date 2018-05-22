package project01.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/bookstore?useUnicode=true&characterEncoding=utf-8";
		final String user = "root";
		final String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
