package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TruckService {
    public void addTruck(Truck truck) {
        try {
            String query = "insert into truck(name,model,capacity,driver_name) values(?,?,?,?)";
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_name());
            int update = preparedStatement.executeUpdate();

            System.out.println("Row Inserted: "+update);

            connection.close();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Truck getTruckBuyId(int id){
        Truck truck = new Truck();
        try {
            String query = "select * from truck where id = ?";
            Connection connection = ConnectionDetails.getConnection();
            //always use prepareStatement for better approach
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));
            }

            connection.close();

            return truck;

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //pahle data database se laao and fir update kr ke bhej sakte ho.
    public void updateTruck(Truck truck){
        try{
            String query = "update truck set name = ?, model = ?, capacity = ?, driver_name = ? where id = ?";
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3, truck.getCapacity());
            preparedStatement.setString(4, truck.getDriver_name());
            preparedStatement.setInt(5, truck.getId());
            int update = preparedStatement.executeUpdate();

            System.out.println("Row updated: "+update);

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Truck> getAllTrucks() {
        List<Truck> trucks = new ArrayList<>();
        try {
            String query = "select * from truck";
            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));

                trucks.add(truck);
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trucks;
    }

    public void deleteTruck(int id){
        try{
            String query = "DELETE FROM truck WHERE id = ?";
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int delete = preparedStatement.executeUpdate();

            System.out.println("Row deleted: "+delete);

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
