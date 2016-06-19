package br.com.valemobi.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		
		try {
			 Class.forName("org.postgresql.Driver");
			 String URL = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
			 String PORT =System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");
			return DriverManager.getConnection("jdbc:postgresql://"+URL+":"+PORT+"/prj", "admintgqbven", "Gwdr-Ty6NH1u");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
