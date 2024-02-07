package Assignment_5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AnimalDataAccessObject {
    private Connection connection;

    // connection from DB to JAVA with jdbc
    public AnimalDataAccessObject() {
        try {
            String url = key.getUrl();
            String user = key.getUser();
            String password = key.getPass();
            connection =  DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // adding Animals to DB
    // prepearedStatement - the most popular feature for adding/updating some statements as a request for something
    public void addAnimal (String name, String species, int age, String status) {
        try {
            String query = "INSERT INTO animals (name, species, age, status) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, species);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, status);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getting list of Animals
    public List<Animal> getAnimals(){
        // creating list for all animals
        List<Animal> animals = new ArrayList<>();

        try{
            String query = "SELECT * FROM animals";

            // by statement, I can get values of fields such us "id", "name" and etc
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String species = resultSet.getString("species");
                int age = resultSet.getInt("age");
                String status = resultSet.getString("status");
                animals.add(new Animal(id, name, species, age, status));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        // returning animals list
        return animals;
    }

    // Updating animal
    public void updateAnimal(int id, String name, String species, int age, String status){
        try {
            String query = "UPDATE animals SET name=?, species=?, age=?, status=? WHERE id=?";

            // Same thing as in ADDING Animals, but for updating
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, species);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, status);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Delete animal
    public void deleteAnimal(int id){
        try{
            String query = "DELETE FROM animals WHERE id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // CLOSING connection
    public void closeConnection(){
        try {
            // (clearing table) truncate almost the same us DELETE FROM table_name but faster
            String query = "truncate animals";
            String queryID = "ALTER SEQUENCE animals_id_seq RESTART WITH 1;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            PreparedStatement preparedStatement1 = connection.prepareStatement(queryID);

            preparedStatement1.executeUpdate();
            preparedStatement.executeUpdate();

            if (connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("CONNECTION WITH DATABASE CLOSED.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
