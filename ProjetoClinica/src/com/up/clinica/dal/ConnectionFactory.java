package com.up.clinica.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/clinicaveterinariadb", "SA", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);// devemos logar esse erro
		}
	}
}