package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstProject {
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
            Statement statement = connection.createStatement();

            //create query
            String query = "select * from students";
            //execute query
            //ctrl-alt + v
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                System.out.println("ID: "+id+", Name: "+name+", Course: "+course);
            }
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
