package Assignment_3;

public class Employee extends Person{
    private String name;
    public String surname;
    private String position;
    private double salary;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
        this.id = generateId();
    }

    public Employee(String name, String surname, String position, double salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
    }

    private static int generateId() {
        return nextId++;
    }

    @Override
    public String toString(){
        return "Employee: "+getId()+". Name: "+getName()+" Surname: "+getSurname() + " Position: " + getPosition();
    }
    @Override
    public double getPaymentAmount() {
        return salary;
    }
}
