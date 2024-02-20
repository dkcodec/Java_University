package EndTermProject;

public class PharmacyApp {
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        DrugRepository drugRepository = new DrugRepositoryCRUD(databaseManager);
        ConsoleUserInterface userInterface;
        userInterface = new ConsoleUserInterface();

        int userChoice;
        do {
            if (!EXCEPTION.EXCEPTIONDELETE.startsWith("Drug with id ") && !EXCEPTION.EXCEPTIONBYID.startsWith("Something went wrong!") && !EXCEPTION.EXCEPTIONBYIDFORONEOUTPUT.startsWith("id: ")) {
                userInterface.displayMenu();
            }
            else{
                EXCEPTION.setEXCEPTIONDELETE("");
                EXCEPTION.setEXCEPTIONBYID("");
                EXCEPTION.setEXCEPTIONBYIDFORONEOUTPUT("");
            }
            userChoice = userInterface.readUserChoice();
            if (userChoice != -1){
                userInterface.executeUserChoice(userChoice);
            }
            else{
                continue;
            }
        } while (userChoice != 0);

        // Closing connection and Scanner
        databaseManager.closeConnection();
        userInterface.closeScanner();
    }
}
