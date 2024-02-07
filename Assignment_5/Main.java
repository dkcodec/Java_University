package Assignment_5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnimalDataAccessObject animalDAO = new AnimalDataAccessObject();

        // adding animals by addAnimal function from AnimalDataAccessObject class
        animalDAO.addAnimal("Bulochka", "Cat", 2, "Available");
        animalDAO.addAnimal("Ponchik", "Dog", 4, "Adopted");
        animalDAO.addAnimal("Rizhik", "Cat", 1, "Available");
        animalDAO.addAnimal("Korzhik", "Dog", 1, "Available");

        //Getting all animals as a List
        List<Animal> animalsList = animalDAO.getAnimals();
        System.out.println("All animals: " + animalsList);

        // Updating one animal(Bulochka was adopted)
        animalDAO.updateAnimal(1, "Bulochka", "Cat", 2, "Adopted");

        // Printing updated info
        animalsList = animalDAO.getAnimals();
        System.out.println("Updated animals: " + animalsList);

        //Deleting adopted animals
        animalDAO.deleteAnimal(2);
        animalDAO.deleteAnimal(1);

        //Final list with Available animals
        animalsList = animalDAO.getAnimals();
        System.out.println("Final animals: " + animalsList);

        //closing connection with DB for security, preventing connection leaks and freeing up resources

        animalDAO.closeConnection();
    }
}
