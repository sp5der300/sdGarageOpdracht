package nl.bd.sdbackendeindopdracht.models;

import javax.persistence.*;

@Entity
@Table (name = "carTable")
public class Car {
    @Id
    private Long carId;
    @ManyToOne
    private AppUser customer;
    @Column
    private int orderNr;
    @Column
    private int constructionYear;
    @ManyToOne
    private AppUser workedOnBy;

    public Car(AppUser customer, int orderNr, int constructionYear, AppUser workedOnBy){
        this.customer = customer;
        this.orderNr = orderNr;
        this.constructionYear = constructionYear;
        this.workedOnBy = workedOnBy;
    }

    public Car() {

    }

    public AppUser getCustomer() {
        return customer;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public AppUser getWorkedOnBy() {
        return workedOnBy;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public void setWorkedOnBy(AppUser workedOnBy) {
        this.workedOnBy = workedOnBy;
    }
}
