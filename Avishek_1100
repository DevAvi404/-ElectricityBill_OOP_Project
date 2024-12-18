//Assignment 02
//Author: Avishek Paul [1100]

import java.util.Scanner;
class Fruit {
    String name;
    String taste;
    String size;

    Fruit(String name, String taste, String size) {
        this.name = name;
        this.taste = taste;
        this.size = size;
    }

    void eat() {
        System.out.println("The fruit " + name + " tastes " + taste + ".");
    }

    int getPrice() {
        return 0;
    }
}

class Apple extends Fruit {

    Apple(String size) {
        super("Apple", "sweet", size);
    }
    
    void eat() {
        System.out.println("The fruit " + name + " is " + taste + " and crunchy.");
    }

    int getPrice() {
        return 20;
    }
}

class Orange extends Fruit {

    Orange(String size) {
        super("Orange", "citrusy", size);
    }

    void eat() {
        System.out.println("The fruit " + name + " is " + taste + " and juicy.");
    }

    int getPrice() {
        return 15;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fruitChoice = 0;
        Fruit fruit = null;

        while (true) {
            System.out.println("Enter the fruit choice: 1 for Apple, 2 for Orange");
            fruitChoice = scanner.nextInt();
            scanner.nextLine();

            if (fruitChoice == 1) {
                fruit = new Apple("Medium");
                break;
            }
            else if (fruitChoice == 2) {
                fruit = new Orange("Medium");
                break;
            }
            else {
                System.out.println("Invalid choice. Please enter 1 for Apple or 2 for Orange.");
            }
        }

        fruit.eat();

        System.out.println("How many " + fruit.name + "(s) do you want?");
        int quantity = scanner.nextInt();

        int totalPrice = quantity * fruit.getPrice();
        System.out.println("The total cost is: " + totalPrice + " taka.");

        scanner.close();
    }
}
