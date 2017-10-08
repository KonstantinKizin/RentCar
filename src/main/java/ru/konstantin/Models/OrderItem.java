package ru.konstantin.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orderItems")
public class OrderItem implements Serializable{

    private Set<Car> cars = new HashSet<Car>();

    private int hour;

    private long id;



    public OrderItem(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinTable(name = "item_car" , joinColumns = {@JoinColumn(name = "car_model")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    public Set<Car> getCars() {
        return cars;
    }




    @Column(name = "hour")
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "order=" +
                ", cars=" + cars +
                ", hour=" + hour +
                ", id=" + id +
                '}';
    }
}
