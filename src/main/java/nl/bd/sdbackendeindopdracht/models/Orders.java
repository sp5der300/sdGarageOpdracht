package nl.bd.sdbackendeindopdracht.models;

import java.util.Date;

public class Orders {
    private String name;
    private Date date;
    private Double orderNr;
    private String carBrand;
    private Mechanic workedOnBy;

    public Orders(String name, Date date, Double orderNr, String carBrand, Mechanic workedOnBy) {
        this.name = name;
        this.date = date;
        this.orderNr = orderNr;
        this.carBrand = carBrand;
        this.workedOnBy = workedOnBy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOrderNr(Double orderNr) {
        this.orderNr = orderNr;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setWorkedOnBy(Mechanic workedOnBy) {
        this.workedOnBy = workedOnBy;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Double getOrderNr() {
        return orderNr;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public Mechanic getWorkedOnBy() {
        return workedOnBy;
    }

}
