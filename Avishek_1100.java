//Assignment no: 01
//Autho: Avishek Paul [1100]

import java.util.Scanner;

class ElectricityBill {
    private int consumerNo;
    private String consumerName;
    private int prevReading;
    private int currReading;
    private String connectionType;

    public ElectricityBill(int consumerNo, String consumerName, int prevReading, int currReading, String connectionType) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.prevReading = prevReading;
        this.currReading = currReading;
        this.connectionType = connectionType;
    }

    public int getPrevReading() {
        return prevReading;
    }

    public int getCurrReading() {
        return currReading;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public int getConsumerNo() {
        return consumerNo;
    }

    public String getConsumerName() {
        return consumerName;
    }
}

class BillCalculator {
    public static double calculateBill(int unitsConsumed, String connectionType) {
        double billAmount = 0.0;

        if (connectionType.equalsIgnoreCase("domestic")) {
            billAmount = calculateDomesticBill(unitsConsumed);
        } 
        else if (connectionType.equalsIgnoreCase("commercial")) {
            billAmount = calculateCommercialBill(unitsConsumed);
        } 
        else {
            System.out.println("Invalid connection type.");
            return -1;
        }

        return billAmount;
    }

    private static double calculateDomesticBill(int unitsConsumed) {
        if (unitsConsumed <= 100) {
            return unitsConsumed * 1;
        } 
        else if (unitsConsumed <= 200) {
            return 100 * 1 + (unitsConsumed - 100) * 2.5;
        } 
        else if (unitsConsumed <= 500) {
            return 100 * 1 + 100 * 2.5 + (unitsConsumed - 200) * 4;
        } 
        else {
            return 100 * 1 + 100 * 2.5 + 300 * 4 + (unitsConsumed - 500) * 6;
        }
    }

    private static double calculateCommercialBill(int unitsConsumed) {
        if (unitsConsumed <= 100) {
            return unitsConsumed * 2;
        } else if (unitsConsumed <= 200) {
            return 100 * 2 + (unitsConsumed - 100) * 4.5;
        } else if (unitsConsumed <= 500) {
            return 100 * 2 + 100 * 4.5 + (unitsConsumed - 200) * 6;
        } else {
            return 100 * 2 + 100 * 4.5 + 300 * 6 + (unitsConsumed - 500) * 7;
        }
    }

    public static void displayBill(ElectricityBill bill) {
        int unitsConsumed = bill.getCurrReading() - bill.getPrevReading();

        if (unitsConsumed < 0) {
            System.out.println("\nError: Current reading is less than previous reading.");
            return;
        }

        System.out.println("\nElectricity Bill Details");
        System.out.println("Consumer Number: " + bill.getConsumerNo());
        System.out.println("Consumer Name: " + bill.getConsumerName());
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Connection Type: " + bill.getConnectionType());

        double billAmount = calculateBill(unitsConsumed, bill.getConnectionType());
        if (billAmount != -1) {
            System.out.println("Bill Amount: Rs. " + billAmount);
        } else {
            System.out.println("Invalid data. Cannot calculate the bill.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Consumer Number: ");
        int consumerNo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Consumer Name: ");
        String consumerName = scanner.nextLine();

        int prevReading;
        int currReading;
        String connectionType = "";

        while (true) {
            System.out.print("Enter Previous Month Reading: ");
            prevReading = scanner.nextInt();

            System.out.print("Enter Current Month Reading: ");
            currReading = scanner.nextInt();
            scanner.nextLine(); 

            if (currReading < prevReading) {
                System.out.println("You are entering wrong reading. Please enter the right reading.");
                continue; 
            }

            break; 
        }

        while (true) {
            System.out.println("Select Connection Type: ");
            System.out.println("1. Domestic");
            System.out.println("2. Commercial");
            System.out.print("Enter your choice (1/2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                connectionType = "domestic";
                break;
            } 
            else if (choice == 2) {
                connectionType = "commercial";
                break; 
            }
            else {
                System.out.println("Invalid choice. Please select 1 for Domestic or 2 for Commercial.");
            }
        }

        ElectricityBill bill = new ElectricityBill(consumerNo, consumerName, prevReading, currReading, connectionType);
        BillCalculator.displayBill(bill);

        scanner.close();
    }
}