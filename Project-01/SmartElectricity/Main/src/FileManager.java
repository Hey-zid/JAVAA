import java.io.*;
import java.util.*;

public class FileManager {
    private static final String CUSTOMER_FILE = "customers.txt";
    private static final String METER_FILE = "meters.txt";
    private static final String BILL_FILE = "bills.txt";

    // ================= CUSTOMER METHODS =================

    public void saveCustomer(Customer customer) {
        try (FileWriter writer = new FileWriter(CUSTOMER_FILE, true)) {
            String line = customer.getCustomerId() + "," +
                    customer.getName() + "," +
                    customer.getAddress() + "," +
                    customer.getMeterNumber();
            writer.write(line + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error saving customer: " + e.getMessage());
        }
    }

    public boolean isCustomerIdTaken(String customerId) {
        return findCustomerById(customerId) != null;
    }

    public Customer findCustomerById(String customerId) {
        File file = new File(CUSTOMER_FILE);
        if (!file.exists()) {
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(customerId)) {
                    return new Customer(parts[0], parts[1], parts[2], parts[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading customer file: " + e.getMessage());
        }

        return null;
    }

    // ================= METER METHODS =================

    public void saveMeter(Meter meter) {
        try (FileWriter writer = new FileWriter(METER_FILE, true)) {
            String line = meter.getCustomerId() + "," +
                    meter.getMeterNumber() + "," +
                    meter.getPreviousReading() + "," +
                    meter.getCurrentReading();
            writer.write(line + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error saving meter reading: " + e.getMessage());
        }
    }

    // Returns the most recent meter reading for a customer (used to auto-fill "previous reading")
    public Meter findMeterByCustomerId(String customerId) {
        File file = new File(METER_FILE);
        if (!file.exists()) {
            return null;
        }

        Meter result = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(customerId)) {
                    int prev = Integer.parseInt(parts[2]);
                    int curr = Integer.parseInt(parts[3]);
                    result = new Meter(parts[0], parts[1], prev, curr);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading meter file: " + e.getMessage());
        }

        return result;
    }

    // Returns ALL meter readings for a customer, in file order (oldest first)
    public List<Meter> findAllMetersByCustomerId(String customerId) {
        List<Meter> meters = new ArrayList<>();
        File file = new File(METER_FILE);

        if (!file.exists()) {
            return meters;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(customerId)) {
                    int prev = Integer.parseInt(parts[2]);
                    int curr = Integer.parseInt(parts[3]);
                    meters.add(new Meter(parts[0], parts[1], prev, curr));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading meter file: " + e.getMessage());
        }

        return meters;
    }

    // Finds the oldest meter reading for this customer that has NOT been billed yet
    public Meter findNextUnbilledMeter(String customerId) {
        List<Meter> allMeters = findAllMetersByCustomerId(customerId);
        List<Bill> allBills = findBillsByCustomerId(customerId);

        for (Meter meter : allMeters) {
            boolean alreadyBilled = false;
            for (Bill bill : allBills) {
                if (bill.getReading() == meter.getCurrentReading()) {
                    alreadyBilled = true;
                    break;
                }
            }
            if (!alreadyBilled) {
                return meter;
            }
        }

        return null; // every reading already has a bill
    }

    // ================= BILL METHODS =================

    public void saveBill(Bill bill) {
        try (FileWriter writer = new FileWriter(BILL_FILE, true)) {
            String line = bill.getCustomerId() + "," +
                    bill.getMonth() + "," +
                    bill.getUnitsUsed() + "," +
                    bill.getReading() + "," +
                    bill.getStatus();
            writer.write(line + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }
    }

    // Returns all bills belonging to a given Customer ID, in file order (oldest first)
    public List<Bill> findBillsByCustomerId(String customerId) {
        List<Bill> bills = new ArrayList<>();
        File file = new File(BILL_FILE);

        if (!file.exists()) {
            return bills;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5 && parts[0].equals(customerId)) {
                    int units = Integer.parseInt(parts[2]);
                    int reading = Integer.parseInt(parts[3]);
                    bills.add(new Bill(parts[0], parts[1], units, reading, parts[4]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading bill file: " + e.getMessage());
        }

        return bills;
    }
}