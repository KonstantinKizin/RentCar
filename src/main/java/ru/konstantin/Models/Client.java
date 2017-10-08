package ru.konstantin.Models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Clients")
public class Client implements Serializable{

    private String name;

    private String sureName;

    private String pasNumber;

    private String email;


    private List<Order> orders = new ArrayList<>();


    public Client(){ }



    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_order" , joinColumns = {@JoinColumn(name = "order_id" )  },
            inverseJoinColumns = {@JoinColumn(name = "passport_info")})
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sure_Name")
    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    @Id
    @Column(name = "passport_info")
    public String getPasNumber() {
        return pasNumber;
    }

    public void setPasNumber(String pasNumber) {
        this.pasNumber = pasNumber;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((pasNumber == null) ? 0 : pasNumber.hashCode());
        result = prime * result
                + ((sureName == null) ? 0 : sureName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pasNumber == null) {
            if (other.pasNumber != null)
                return false;
        } else if (!pasNumber.equals(other.pasNumber))
            return false;
        if (sureName == null) {
            if (other.sureName != null)
                return false;
        } else if (!sureName.equals(other.sureName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Client [name=" + name + ", sureName=" + sureName
                + ", pasNumber=" + pasNumber + ", email=" + email + ", id="
                +  "]";
    }
}
