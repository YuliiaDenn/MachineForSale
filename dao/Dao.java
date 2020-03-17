package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

	public final String URL = "jdbc:mysql://localhost:3306/machine_for_sale?serverTimezone=Europe/Kiev";

	public Connection getConnection() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(URL, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connect;
	}

}
