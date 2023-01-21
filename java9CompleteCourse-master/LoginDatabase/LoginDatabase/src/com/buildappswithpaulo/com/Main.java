package com.buildappswithpaulo.com;


import com.buildappswithpaulo.com.Helper.DBHandler;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;
    static private PreparedStatement preparedStatement;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        dbHandler = new DBHandler();
        connection = dbHandler.getDbConnection();




       // writeToDB();
        // readFromDB();
        //updateDB("Santos", "Santana", "santana", "1343 south", 68, 4);

        //deleteUser(1);


    }

    public static void writeToDB() throws SQLException {

        String insert = "INSERT INTO users(firstname,lastname,username,address,age)"
                + "VALUES(?,?,?,?,?)";

        preparedStatement = (PreparedStatement) connection.prepareStatement(insert);

        preparedStatement.setString(1, "Antonio");
        preparedStatement.setString(2, "Banderas");
        preparedStatement.setString(3, "banderas");
        preparedStatement.setString(4, "1234 West Beach");
        preparedStatement.setInt(5, 56);
        preparedStatement.executeUpdate();


    }

    public static void readFromDB() throws SQLException {

        String query = "SELECT * from users";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Names: " + resultSet.getString("firstname") +
                    " " + resultSet.getString("lastname") +
                    " " + resultSet.getInt("age") +
                    " " + resultSet.getString("address"));

        }


    }

    public static void updateDB(String firstName, String lastName, String username,
                                String address, int age, int id) {

        String query = "UPDATE users SET firstname = ?, lastname = ?, username = ?, address = ?, age = ? "
                + " where userid = ? ";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, age);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteUser(int id) {
        String query = "DELETE FROM users where userid = ?";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
