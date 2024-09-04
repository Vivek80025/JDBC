package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {
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

            //create statement
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE
            );
            //INSENSITIVE=>if ham DB me kuch changing krenge(through DB) to resultSet me changin show nhi krega.
            //SENSITIVE=>if ham DB me kuch changing krenge(through DB) to resultSet me bhi changin show krega.

            //create query
            String query = "select * from students";
            //execute query
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.last();
            System.out.println("fetching last row: ");
            System.out.println("ID: "+resultSet.getInt("id"));
            System.out.println("Name: "+resultSet.getString("name"));

            resultSet.first();
            System.out.println("fetching first row: ");
            System.out.println("ID: "+resultSet.getInt("id"));
            System.out.println("Name: "+resultSet.getString("name"));

            resultSet.updateString("name","Sneha");
            resultSet.updateRow();

            System.out.println("fetching first row: ");
            System.out.println("ID: "+resultSet.getInt("id"));
            System.out.println("Name: "+resultSet.getString("name"));

            resultSet.moveToInsertRow();
            resultSet.updateInt("id",5);
            resultSet.updateString("name","Amrish");
            resultSet.updateString("course","System Design");
            resultSet.insertRow();

            System.out.println("fetching New row: ");
            System.out.println("ID: "+resultSet.getInt("id"));
            System.out.println("Name: "+resultSet.getString("name"));
            System.out.println("Course: "+resultSet.getString("course"));


            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
