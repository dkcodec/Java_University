package Assignment_2.Assignment_1;

import java.util.Scanner;

public class main extends Circle{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Circle circle1 = new Circle();
        System.out.print("Enter radius value: ");
        circle1.setRadius(scanner.nextInt());

        System.out.println("Area: " + circle1.calculateArea(circle1.getRadius()));
        System.out.println("--------------------------------");
        System.out.println("Perimetr: " + circle1.calculatePerimetr(circle1.getRadius()));

    }
}
