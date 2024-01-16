package Assignment_3;

public class Person implements Payable, Comparable<Person>{
    protected static int nextId = 1;  // helper static variable for generating unique IDs

    protected int id;
    private String name;
    private String surname;

    @Override
    public String toString(){
        return id+"."+name+" "+surname;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Person() {
        this.id = generateId();
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getPosition(){
        return "Student";
    }

    private static int generateId() {
        return nextId++;
    }

    @Override
    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public int compareTo(Person o) {
        return  Double.compare(this.getPaymentAmount(), o.getPaymentAmount());
    }
}
