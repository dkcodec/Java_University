package Assignment_5;

public class Animal {
    private int id;
    private String name;
    private String species;
    private int age;
    private String status;


    // Constructor for assigning variables
    public Animal(int id, String name, String species, int age, String status) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Overriding toString for format output
    @Override
    public String toString() {
        return "Animal {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", species='" + getSpecies() + '\'' +
                ", age=" + getAge() +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
