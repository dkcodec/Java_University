package Assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class dataBase {

    public static void main(String[] args) {
// РАБОТА С БАЗОЙ ДАННЫХ POSTGRESQL ЧЕРЕЗ JDBC
        try {
// Адрес нашей базы данных "tsn_pg_demo" на локальном компьютере (localhost)
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/test_bd";

// Создание свойств соединения с базой данных
            Properties authorization = new Properties();
            authorization.put("user", "postgres"); // Зададим имя пользователя БД
            authorization.put("password", key.getBD_key()); // Зададим пароль доступа в БД

// Создание соединения с базой данных
            Connection connection = DriverManager.getConnection(url, authorization);

// Создание оператора доступа к базе данных
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

// Выполнение запроса к базе данных, получение набора данных
            ResultSet table = statement.executeQuery("SELECT * FROM users");

            table.first(); // Выведем имена полей
            for (int j = 1; j <= table.getMetaData().getColumnCount(); j++) {
                System.out.print(table.getMetaData().getColumnName(j) + "\t\t");
            }
            System.out.println();

            table.beforeFirst(); // Выведем записи таблицы
            while (table.next()) {
                for (int j = 1; j <= table.getMetaData().getColumnCount(); j++) {
                    System.out.print(table.getString(j) + "\t\t");
                }

                System.out.println();
            }

            if (table != null) { table.close(); } // Закрытие набора данных
            if (statement != null) { statement.close(); } // Закрытие базы данных
            if (connection != null) { connection.close(); } // Отключение от базы данных

        } catch (Exception e) {
            System.err.println("Error accessing database!");
            e.printStackTrace();
        }
    }

}
