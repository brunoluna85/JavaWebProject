package br.com.mercs.projetoweb.main;

import java.sql.DriverManager;

public class JdbcConnection {

	public static void conectar() {

		String jdbcUrl = "jdbc:mysql://localhost:3306/projetoweb?useSSL=false";
		String user = "root";
		String pass = "q1w2e3r4";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}



