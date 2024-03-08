package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn;

public static Connection getConn() {
try {
if (conn == null) {
Class.forName("com.mysql.cj.jdbc.Driver");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal_4","root", "SAurav@001"
		);
}
} catch (Exception e) { e.printStackTrace();
}
return conn;
}
}