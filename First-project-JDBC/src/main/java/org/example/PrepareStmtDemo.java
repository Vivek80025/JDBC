package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PrepareStmtDemo {
    public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/studentdb";
    public static String PASSWORD = "Vivek@80025";
    public static String USERNAME = "root";
    public static void main(String[] args) {
        try {
            //load driver
            Class.forName(LOAD_DRIVER);

            //making connection
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            /*
            //query
            //good(preferable) approach for delete data
            //resultSet is preferable for fetch query
            //prepareStatement is preferable for data update of delete
            String query = "delete from students where id=?";
            //prepareStatement -> for delete the row/data for database
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //we can take input(which id) from user
            preparedStatement.setInt(1,3);
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println("Row Affected: "+rowAffected);
            */

            String insertQuery = "insert into students (id,name,course) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1,3);
            preparedStatement.setString(2,"tannu");
            preparedStatement.setString(3,"Machine learning");
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println("Row Affected: "+rowAffected);

            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
