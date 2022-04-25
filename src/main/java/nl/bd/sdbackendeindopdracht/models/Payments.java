package nl.bd.sdbackendeindopdracht.models;

public class Payments {

    private String customerName;
    private int orderNr;
    private double price;

    public Payments(String customerName, int orderNr, double price){
        this.customerName = customerName;
        this.orderNr = orderNr;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public double getPrice() {
        return price;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
