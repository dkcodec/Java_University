package Assignment_1;

public class MAIN {
    public static void main(String[] args) {
        Person person1 = new Person("Dima", 18);
        System.out.println("My name is " + person1.getName() + ", my age is " + person1.getAge());
        System.out.println("-------------------------------");// for visualization
        person1.printDetails();
        System.out.println("-------------------------------");
    }
}
