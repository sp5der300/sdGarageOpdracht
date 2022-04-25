package nl.bd.sdbackendeindopdracht.models;

import nl.bd.sdbackendeindopdracht.security.enums.Roles;
import org.springframework.data.spel.spi.Function;

public class Customer {

    private String name;
    private String address;
    private String function;
    private int customerNumber;
    private Roles customerRole;

    public Customer(String name, String address, String function, double customerNumber, Roles customerRole){
        this.name = name;
        this.address = address;
        this.function = function;
        this.customerNumber = (int) customerNumber;
        this.customerRole = Roles.CUSTOMER;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getFunction() {
        return function;
    }

    public double getCustomerNumber() {
        return customerNumber;
    }

    public Roles getCustomerRole() {
        return customerRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setCustomerNumber(double customerNumber) {
        this.customerNumber = (int) customerNumber;
    }

    public void setCustomerRole(Roles customerRole) {
        this.customerRole = customerRole;
    }
}
