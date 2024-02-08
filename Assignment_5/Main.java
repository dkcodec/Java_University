package Assignment_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalDataAccessObject animalDAO = new AnimalDataAccessObject();

        // Input info for DB by Scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Input NAME, SPECIES, AGE, Status by spaces:");
        String input1 = scan.nextLine();
        // Spliting elemnts
        String[] dbArguments = input1.split(" ");

        // adding entered element to db and Parsing AGE to int
        animalDAO.addAnimal(dbArguments[0], dbArguments[1], Integer.parseInt(dbArguments[2]), dbArguments[3]);

        // adding animals by addAnimal function from AnimalDataAccessObject class
        animalDAO.addAnimal("Bulochka", "Cat", 2, "Available");
        animalDAO.addAnimal("Ponchik", "Dog", 4, "Adopted");
        animalDAO.addAnimal("Rizhik", "Cat", 1, "Available");
        animalDAO.addAnimal("Korzhik", "Dog", 1, "Available");

        //Getting all animals as a List
        List<Animal> animalsList = animalDAO.getAnimals();
        System.out.println("All animals: " + animalsList);

        // Updating one animal(Bulochka was adopted)
        animalDAO.updateAnimal(2, "Bulochka", "Cat", 2, "Adopted");

        // Printing updated info
        animalsList = animalDAO.getAnimals();
        System.out.println("Updated animals: " + animalsList);

        System.out.println("ANMAL STATUS for 0 el: " + animalsList.get(0).getStatus() + " NAME: " + animalsList.get(0).getName());

        //Deleting adopted animals
        for (int i = 0; i < animalsList.size(); i++){
            if (Objects.equals(animalsList.get(i).getStatus(), "Adopted")){
                System.out.println(" Deleted animal: "+animalsList.get(i) + ". YES THIS ANIMAL WAS ADOPTED!!! :) ");
                animalDAO.deleteAnimal(animalsList.get(i).getId());
            }
        }

        //Final list with Available animals
        animalsList = animalDAO.getAnimals();
        System.out.println("Final animals: " + animalsList);

        //closing connection with DB for security, preventing connection leaks and freeing up resources

        animalDAO.closeConnection();
    }
}
