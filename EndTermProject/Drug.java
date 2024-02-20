package EndTermProject;

//This class represents a drug and contains information about it such as ID, name, price and other properties.

public class Drug {
    private int id;
    private String name;
    private int price;

    // constructor

    public Drug(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Drug() {

    }

    public Drug(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Getters Setters
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

