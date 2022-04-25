package nl.bd.sdbackendeindopdracht.models;

public class Car {

    private Customer customer;
    private int orderNr;
    private int constructionYear;
    private Mechanic workedOnBy;

    public Car(Customer customer, int orderNr, int constructionYear, Mechanic workedOnBy){
        this.customer = customer;
        this.orderNr = orderNr;
        this.constructionYear = constructionYear;
        this.workedOnBy = workedOnBy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public Mechanic getWorkedOnBy() {
        return workedOnBy;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public void setWorkedOnBy(Mechanic workedOnBy) {
        this.workedOnBy = workedOnBy;
    }
}
