package Model;

public class Customer {
    private String name;
    private int amount = 0;
    private boolean isVip;
    private double bill = 0;

    public Customer(String name, int amount, boolean isVip, double bill) {
        this.name = name;
        this.amount = amount;
        this.isVip = isVip;
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount += amount;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill += bill;
    }
}
