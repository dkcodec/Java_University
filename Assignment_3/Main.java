package Assignment_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> peopleList = new ArrayList<Person>();

        Employee employee1 = new Employee("John", "Lennon", "Manager", 27045.78);
        Employee employee2 = new Employee("George", "Harrison", "Developer", 50000.00);
        Student student1 = new Student("Ringo", "Starr", 2.5);
        Student student2 = new Student("Paul", "McCartney", 3.5);


        peopleList.add(employee1);
        peopleList.add(employee2);
        peopleList.add(student1);
        peopleList.add(student2);

        Collections.sort(peopleList);

        printData(peopleList);
    }
    public static void printData(Iterable<Person> people){
        for(Person person: people){
            if(person instanceof Employee){
                System.out.println(person.toString() + " earns " + ((Employee) person).getPaymentAmount() + " tenge");
            } else if(person instanceof Student){
                System.out.println(person.toString() + " earns " + ((Student) person).getPaymentAmount() + " tenge");
            }
        }
    }
}
