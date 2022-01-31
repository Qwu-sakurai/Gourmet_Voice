package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String URL = "jdbc:postgresql://localhost:5432/guruvoi_db";
	private static final String USER = "postgres";
	private static final String PASS = "root";

	public static Connection getConnection()
		throws SQLException, ClassNotFoundException {

		// JDBCドライバの読み込み
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(URL, USER, PASS);

	}
}
