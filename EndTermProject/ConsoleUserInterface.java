package EndTermProject;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private final Scanner scanner;

    public ConsoleUserInterface() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("1. Add Drug");
        System.out.println("2. Update Drug");
        System.out.println("3. Delete Drug");
        System.out.println("4. View Drug Details by ID");
        System.out.println("5. View All Drugs");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
    }

    @Override
    public int readUserChoice() {
        try {
            String read = scanner.nextLine();
            return Integer.parseInt(read);
        }catch (NumberFormatException e){
            return -1; // Чтобы обработать ошибку ввода пользователя
        }
    }

    @Override
    public void executeUserChoice(int choice) {
        DatabaseManager databaseManager = new DatabaseManager();
        DrugRepositoryCRUD drugRepositoryCRUD = new DrugRepositoryCRUD(databaseManager);
        switch (choice) {
            case 1: {
                System.out.println("Enter name and price:");
                try {
                    String props = scanner.nextLine();
                    String[] propsARR = props.toLowerCase().split(" ");
                    String name = propsARR[0];
                    int price = Integer.parseInt(propsARR[1]);
                    Drug propsDrug = new Drug(name, price);
                    drugRepositoryCRUD.addDrug(propsDrug);
                } catch (Exception e){
                    System.out.println("Something went wrong! Please repeat " + e);
                }
                break;
            }
            case 2: {
                System.out.println("Enter id, name and price:");
                try {
                    String props = scanner.nextLine();
                    String[] propsARR = props.toLowerCase().split(" ");
                    int id = Integer.parseInt(propsARR[0]);
                    String name = propsARR[1];
                    int price = Integer.parseInt(propsARR[2]);
                    Drug propsDrug = new Drug(id, name, price);
                    drugRepositoryCRUD.updateDrug(propsDrug);
                } catch (Exception e){
                    System.out.println("Something went wrong! Please repeat " + e);
                }
                break;
            }
            case 3: {
                System.out.println("Enter id:");
                try {
                    int id = scanner.nextInt();
                    drugRepositoryCRUD.deleteDrug(id);
                } catch (Exception e){
                    System.out.println("Something went wrong! Please repeat " + e);
                }
                break;
            }
            case 4: {
                System.out.println("Enter id:");
                try{
                    int id = scanner.nextInt();
                    Drug drug;
                    drug = drugRepositoryCRUD.getDrugById(id);
                    System.out.println("id: " + drug.getId() + " name: " + drug.getName() + " price: " + drug.getPrice());
                    EXCEPTION.EXCEPTIONBYIDFORONEOUTPUT = "id: ";
                } catch (Exception e){
                    System.out.println("Something went wrong! Please repeat " + e);
                    EXCEPTION.setEXCEPTIONBYID("Something went wrong! Please repeat");
                }
                break;
            }
            case 5: {
                for (Drug dr: drugRepositoryCRUD.getAllDrugs()){
                    System.out.println("id: " + dr.getId() + " name: " + dr.getName() + " price: " + dr.getPrice());
                }
                break;
            }
            case 0: {
                System.out.println("Exiting the application. Goodbye!");
                break;
            }
            default:{
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
            }
        }
    }
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
