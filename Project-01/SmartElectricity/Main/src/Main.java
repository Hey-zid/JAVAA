import java.util.List;
import java.util.Scanner;

public class Main {
    private static final double RATE_PER_UNIT = 5.0; // Taka per unit - change here if rate changes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        boolean running = true;

        while (running) {
            System.out.println("\n========================================");
            System.out.println("       ELECTRICITY MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Register New Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Add Meter Reading");
            System.out.println("4. Add Monthly Bill");
            System.out.println("5. Check Annual Bill");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerCustomer(scanner, fileManager);
                    break;
                case "2":
                    searchCustomer(scanner, fileManager);
                    break;
                case "3":
                    addMeterReading(scanner, fileManager);
                    break;
                case "4":
                    addMonthlyBill(scanner, fileManager);
                    break;
                case "5":
                    checkAnnualBill(scanner, fileManager);
                    break;
                case "6":
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void registerCustomer(Scanner scanner, FileManager fileManager) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        if (fileManager.isCustomerIdTaken(id)) {
            System.out.println("Error: Customer ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Meter Number: ");
        String meterNumber = scanner.nextLine();

        Customer customer = new Customer(id, name, address, meterNumber);
        fileManager.saveCustomer(customer);

        System.out.println("Customer registered successfully!");
    }

    private static void searchCustomer(Scanner scanner, FileManager fileManager) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        Customer customer = fileManager.findCustomerById(id);

        if (customer == null) {
            System.out.println("Customer not found.");
        } else {
            System.out.println("\n--- Customer Found ---");
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Meter Number: " + customer.getMeterNumber());
        }
    }

    private static void addMeterReading(Scanner scanner, FileManager fileManager) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        Customer customer = fileManager.findCustomerById(id);
        if (customer == null) {
            System.out.println("Error: Customer does not exist. Register the customer first.");
            return;
        }

        Meter lastMeter = fileManager.findMeterByCustomerId(id);
        int previousReading;
        int currentReading;

        if (lastMeter == null) {
            System.out.println("No previous reading found. Please enter both readings.");

            System.out.print("Enter Previous Reading: ");
            previousReading = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Current Reading: ");
            currentReading = Integer.parseInt(scanner.nextLine());
        } else {
            previousReading = lastMeter.getCurrentReading();
            System.out.println("Previous Reading (auto-filled from last record): " + previousReading);

            System.out.print("Enter Current Reading: ");
            currentReading = Integer.parseInt(scanner.nextLine());
        }

        if (previousReading < 0 || currentReading < 0) {
            System.out.println("Error: Readings cannot be negative.");
            return;
        }

        if (currentReading < previousReading) {
            System.out.println("Error: Current reading cannot be less than previous reading.");
            return;
        }

        Meter meter = new Meter(id, customer.getMeterNumber(), previousReading, currentReading);
        fileManager.saveMeter(meter);

        System.out.println("Meter reading saved successfully!");
        System.out.println("Units Used: " + meter.getUnitsUsed());
    }

    private static void addMonthlyBill(Scanner scanner, FileManager fileManager) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        Customer customer = fileManager.findCustomerById(id);
        if (customer == null) {
            System.out.println("Error: Customer does not exist. Register the customer first.");
            return;
        }

        Meter meter = fileManager.findNextUnbilledMeter(id);
        if (meter == null) {
            System.out.println("Error: No unbilled meter reading found for this customer.");
            System.out.println("Either no readings exist, or all existing readings already have bills.");
            return;
        }

        System.out.print("Enter Month (e.g. January 2026): ");
        String month = scanner.nextLine();

        System.out.print("Enter Payment Status (Paid/Unpaid): ");
        String status = scanner.nextLine();

        if (!status.equalsIgnoreCase("Paid") && !status.equalsIgnoreCase("Unpaid")) {
            System.out.println("Error: Status must be 'Paid' or 'Unpaid'.");
            return;
        }

        int unitsUsed = meter.getUnitsUsed();
        int reading = meter.getCurrentReading();

        Bill bill = new Bill(id, month, unitsUsed, reading, status);
        fileManager.saveBill(bill);

        double cost = unitsUsed * RATE_PER_UNIT;

        System.out.println("Bill created successfully!");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Month: " + bill.getMonth());
        System.out.println("Units: " + bill.getUnitsUsed());
        System.out.println("Reading: " + bill.getReading());
        System.out.println("Amount: " + cost + " Taka");
        System.out.println("Status: " + bill.getStatus());
    }

    // Handles displaying the annual bill/usage report for a customer
    private static void checkAnnualBill(Scanner scanner, FileManager fileManager) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        Customer customer = fileManager.findCustomerById(id);
        if (customer == null) {
            System.out.println("Error: Customer does not exist.");
            return;
        }

        List<Bill> bills = fileManager.findBillsByCustomerId(id);
        if (bills.isEmpty()) {
            System.out.println("No bills found for this customer yet.");
            return;
        }

        System.out.println("\nCustomer Name: " + customer.getName());
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Meter Number: " + customer.getMeterNumber());
        System.out.println();
        System.out.printf("%-18s%-10s%-12s%-12s%-10s%n", "MONTH", "UNITS", "READING", "AMOUNT", "STATUS");

        int totalUnits = 0;
        int paidCount = 0;
        int unpaidCount = 0;
        double totalBilled = 0;
        double totalPaid = 0;
        double totalDue = 0;

        for (Bill bill : bills) {
            double cost = bill.getUnitsUsed() * RATE_PER_UNIT;

            System.out.printf("%-18s%-10d%-12d%-12.2f%-10s%n",
                    bill.getMonth(), bill.getUnitsUsed(), bill.getReading(), cost, bill.getStatus());

            totalUnits += bill.getUnitsUsed();
            totalBilled += cost;

            if (bill.getStatus().equalsIgnoreCase("Paid")) {
                paidCount++;
                totalPaid += cost;
            } else {
                unpaidCount++;
                totalDue += cost;
            }
        }

        System.out.println();
        System.out.println("Total Annual Units: " + totalUnits);
        System.out.println("Paid Bills: " + paidCount);
        System.out.println("Unpaid Bills: " + unpaidCount);
        System.out.println("Total Billed Amount: " + totalBilled + " Taka");
        System.out.println("Total Amount Paid: " + totalPaid + " Taka");
        System.out.println("Total Amount Due: " + totalDue + " Taka");
    }
}