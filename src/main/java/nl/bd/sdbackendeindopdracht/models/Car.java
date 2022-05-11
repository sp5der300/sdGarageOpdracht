package nl.bd.sdbackendeindopdracht.models;

import javax.persistence.*;

@Entity
@Table (name = "carTable")

public class Car {
    @Id
    private Long id;
    @ManyToOne
    private Customer customer;
    @Column
    private int orderNr;
    @Column
    private int constructionYear;
    @ManyToOne
    private Mechanic workedOnBy;

    public Car(Customer customer, int orderNr, int constructionYear, Mechanic workedOnBy){
        this.customer = customer;
        this.orderNr = orderNr;
        this.constructionYear = constructionYear;
        this.workedOnBy = workedOnBy;
    }

    public Car() {

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
