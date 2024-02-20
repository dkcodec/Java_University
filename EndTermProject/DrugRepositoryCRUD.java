package EndTermProject;

import Assignment_5.Animal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//This class implements the DrugRepository interface and contains the logic for interacting with the drug database.


public class DrugRepositoryCRUD extends DatabaseManager implements DrugRepository{
    DatabaseManager databaseManager = new DatabaseManager();
    public DrugRepositoryCRUD(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public void addDrug(Drug drug) {
        try {
            String query = "INSERT INTO drugs (name, price) VALUES (?, ?)";

            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, drug.getName());
            preparedStatement.setInt(2, drug.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            String exc = String.valueOf(e);
        }
    }

    @Override
    public void updateDrug(Drug drug) {
        try {
            String query = "UPDATE drugs SET name=?, price=? WHERE id=?";

            // Same thing as in ADDING Animals, but for updating
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, drug.getName());
            preparedStatement.setInt(2, drug.getPrice());
            preparedStatement.setInt(3, drug.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            String exc = String.valueOf(e);
        }
    }

    @Override
    public void deleteDrug(int drugId) {
        try {
            // Получаем информацию о лекарстве перед удалением
            Drug drugToDelete = getDrugById(drugId);

            if (drugToDelete != null) {
                // Удаляем лекарство
                String deleteSql = "DELETE FROM drugs WHERE id = ?";
                try (PreparedStatement deleteStatement = getConnection().prepareStatement(deleteSql)) {
                    deleteStatement.setInt(1, drugId);
                    deleteStatement.executeUpdate();
                }

                // Обновляем идентификаторы других лекарств, если нужно
                updateDrugIdsAfterDeletion(drugToDelete.getId());
            } else {
                System.out.println("Drug with id " + drugId + " not found.");
                EXCEPTION.setEXCEPTIONDELETE("Drug with id " + drugId + " not found.");
                throw new SQLException();
            }
        } catch (SQLException e) {
            String exc = String.valueOf(e);
            // Обработка ошибок удаления или обновления идентификаторов
        }
    }

    private void updateDrugIdsAfterDeletion(int deletedId) {
        try {
            // Обновляем идентификаторы лекарств с большими значениями, чем удаленный идентификатор
            String updateSql = "UPDATE drugs SET id = id - 1 WHERE id > ?";
            try (PreparedStatement updateStatement = getConnection().prepareStatement(updateSql)) {
                updateStatement.setInt(1, deletedId);
                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {
            String exc = String.valueOf(e);
            // Обработка ошибок при обновлении идентификаторов
        }
    }


    @Override
    public Drug getDrugById(int drugId) {
        Drug drug = null;

        try {
            String sql = "SELECT id, name, price FROM drugs WHERE id = ?";
            try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                statement.setInt(1, drugId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        drug = new Drug();
                        drug.setId(resultSet.getInt("id"));
                        drug.setName(resultSet.getString("name"));
                        drug.setPrice(resultSet.getInt("price"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Drug with id " + drugId + " not found.");
            EXCEPTION.setEXCEPTIONBYID("Drug with id " + drugId + " not found.");
            String exc = String.valueOf(e);
            // Finding exception with DB
        }

        return drug;
    }

    @Override
    public List<Drug> getAllDrugs() {
        // creating list for all animals
        List<Drug> drugs = new ArrayList<>();

        try{
            String query = "SELECT * FROM drugs";

            // by statement, I can get values of fields such us "id", "name" and etc
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                drugs.add(new Drug(id, name, price));
            }

        }catch (SQLException e){
            String exc = String.valueOf(e);
        }

        // returning animals list
        return drugs;
    }
}
