package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String URL = "jdbc:mysql://localhost:3306/guruvoi_db?useSSL=false";
	private static final String USER = "admin";
	private static final String PASS = "admin";

	public static Connection getConnection()
		throws SQLException, ClassNotFoundException {

		// JDBCドライバの読み込み
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASS);

	}
}
