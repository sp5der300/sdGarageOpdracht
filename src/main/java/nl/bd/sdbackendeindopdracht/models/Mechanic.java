package nl.bd.sdbackendeindopdracht.models;

import nl.bd.sdbackendeindopdracht.security.enums.Roles;

public class Mechanic {

    private String name;
    private String function;
    private Mechanic workedOnBy;
    private Roles mechanicRole;

    public Mechanic(String name, String function, Mechanic workedOnBy, Roles mechanicRole){
        this.name = name;
        this.function = function;
        this.workedOnBy = workedOnBy;
        this.mechanicRole = mechanicRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setWorkedOnBy(Mechanic workedOnBy) {
        this.workedOnBy = workedOnBy;
    }

    public void setMechanicRole(Roles mechanicRole) {
        this.mechanicRole = mechanicRole;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

    public Mechanic getWorkedOnBy() {
        return workedOnBy;
    }

    public Roles getMechanicRole() {
        return mechanicRole;
    }
}
