package com.epam.HomeTask_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://EPINHYDW0087:3306/programs", "qa",
					"qa123");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from Participants");
			while (resultset.next()) {
				System.out.println("ID = " + resultset.getInt(1) + " Name = " + resultset.getString(2)
						+ " Email Address = " + resultset.getString(3));
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
