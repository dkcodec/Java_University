package EndTermProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    // getting URL, PASSWORD, USER from key.java
    private static final String URL = key.getUrl();
    private static final String USER = key.getUser();
    private static final String PASSWORD = key.getPass();

    // Connecting to DB
    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            // Finding Exceptions with connecting
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            // (clearing table) truncate almost the same us DELETE FROM table_name but faster
            String query = "truncate drugs";
            String queryID = "ALTER SEQUENCE drugs_id_seq RESTART WITH 1;";
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

