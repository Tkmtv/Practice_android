package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Sale {
    private Map<String, Customer> customers;
    private int totalCustomers;
    private int numberVIP;
    private double totalSale;

    public Sale() {
        this.customers = new HashMap<>();
        update();
    }

    public void update() {
        this.totalCustomers = customers.size() == 0 ? 0 : customers.size();
        numberVIP = 0;
        for (String name : customers.keySet()) {
            if (customers.get(name).isVip()) {
                numberVIP++;
            }
            this.totalSale += customers.get(name).getBill();
        }
    }

    public double calBill(int amount, boolean isVip) {
        double rawBill = amount * 20000;
        if (isVip) {
            rawBill = rawBill * (1 - 0.1);
        }
        return rawBill;
    }

    public void saveInfo(String name, int amount, boolean isVip, double bill) {
        if (!customers.containsKey(name)) {
            customers.put(name, new Customer(name, amount, isVip, bill));
        } else {
            customers.get(name).setAmount(amount);
            customers.get(name).setVip(isVip);
            customers.get(name).setBill(bill);
        }
        update();
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers = customers;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public int getNumberVIP() {
        return numberVIP;
    }

    public void setNumberVIP(int numberVIP) {
        this.numberVIP = numberVIP;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }
}
