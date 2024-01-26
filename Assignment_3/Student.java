package Assignment_3;

public class Student extends Person implements Payable{
    private String name;
    private String surname;
    private double gpa;

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
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public Student() {
        this.id = generateId();
    }


    public Student(String name, String surname, double gpa) {
        this.name = name;
        this.surname = surname;
        this.gpa = gpa;
    }


    private static int generateId(){
        return nextId++;
    }


    @Override
    public String toString(){
        return "Student: "+getId()+". Name: "+getName()+" Suranme: "+getSurname() + " Position: " + getPosition() + " Gpa:" + getGpa();
    }
    @Override
    public double getPaymentAmount() {
        return (gpa>2.67)?36660.00:0;
    }
}
