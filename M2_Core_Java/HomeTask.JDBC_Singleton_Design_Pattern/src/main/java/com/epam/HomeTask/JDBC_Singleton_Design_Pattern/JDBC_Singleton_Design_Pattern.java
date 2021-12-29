package com.epam.HomeTask.JDBC_Singleton_Design_Pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Singleton_Design_Pattern {

	private static Connection connection;

	private JDBC_Singleton_Design_Pattern() {

	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://EPINHYDW0087:3306/programs", "qa", "qa123");

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return connection;
	}

	public static void main(String[] args) {
		Connection connection = JDBC_Singleton_Design_Pattern.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultset = statement
					.executeQuery("select * from batch_final_result where college_id=103 and batch_id=38");
			while (resultset.next()) {
				System.out.println("ID = " + resultset.getInt(1) + " Email Address = " + resultset.getString(2)
						+ " Full Name = " + resultset.getString(3) + " College ID = " + resultset.getInt(4)
						+ " Batch ID = " + resultset.getInt(6));
			}
			connection.close();
			System.out.println("JDBC Connection and Data Fetched by using Singleton Design Pattern!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
