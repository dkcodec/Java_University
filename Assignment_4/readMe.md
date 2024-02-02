# DataBase in Java(postgreSQL)

<hr>

### Creating database:

Some steps for creating dataBase structures in postgre:
<ul>

<li> Download PostgreSql from official site: https://www.postgresql.org
<li> Open pgAdmin app
<li> On the left side of the program, select some database, for example, the standard postgres database, and right-click on it.
<li> В появившемся меню выберем пункт Query Tool..., и в центральной части программы откроется поле для ввода кода SQL. В это поле введем следующий код:

```postgresql
CREATE DATABASE usersdb;
```
and press start button
<li>To see our database, right-click on Databases on the left side and select "Refresh..." in the context menu:
</ul>

### Creating DataBase Table:
```postgresql
CREATE TABLE users
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  surname VARCHAR(30) NOT NULL,
  age INTEGER default 0,
  email VARCHAR(30) NOT NULL
);
```
this table contains id, name, surname, age and email.

### Inserting Elements in table:
As example
```postgresql
INSERT INTO users (id, name, surname, age, email) VALUES (3,'Dmitriy','Dkcodec',18,'dkcodec@github.com');
```
for adding another row just start again this code with other values.

### Selecting table:
for select all elements in user table: 
```postgresql
SELECT * FROM users;
```
### Update element in table:
```postgresql
UPDATE users
SET name = 'Aruan',
surname = 'Rakhimov',
age = 19,
email = 'zhanbatyr@gmail.com';
SELECT name,surname,age FROM users order by name;
```

### Connecting DataBase to Java
<ul>

<li> Install JDBC jar lib for postgre: https://jdbc.postgresql.org/download
</ul>

```java
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
            authorization.put("password", "YOUR_KEY"); // Зададим пароль доступа в БД

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
```
In comment I describe all connection stuff.

<hr>

## Thank you for your attention 















