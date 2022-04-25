package nl.bd.sdbackendeindopdracht.models;

import nl.bd.sdbackendeindopdracht.security.enums.Roles;

public class Workers {

    private String name;
    private String function;
    private Roles roles;

    public Workers(String name, String function, Roles roles) {
        this.name = name;
        this.function = function;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }



}


