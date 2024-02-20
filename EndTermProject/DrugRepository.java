package EndTermProject;

import java.util.List;

// This interface will define methods for working with drug data in the database.
public interface DrugRepository {
    void addDrug(Drug drug);
    void updateDrug(Drug drug);
    void deleteDrug(int drugId);
    Drug getDrugById(int drugId);
    List<Drug> getAllDrugs();
}
