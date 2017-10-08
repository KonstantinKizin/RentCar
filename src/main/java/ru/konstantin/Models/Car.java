package ru.konstantin.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Cars")
public class Car implements Serializable{


    private String carModel;

    private int pricePerHoure;

    private Brand brand;

    private int countOf;

    @Column(name = "counts")
    public int getCountOf() {
        return countOf;
    }

    public void setCountOf(int countOf) {
        this.countOf = countOf;
    }

    private long carId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public Car() {

    }

    @Column(name = "price")
    public int getPricePerHoure() {
        return pricePerHoure;
    }


    @Column(name = "car_model")
    public String getCarModel() {
        return carModel;
    }




    @Embedded
    public Brand getBrand() {
        return brand;
    }


    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setPricePerHoure(int price_per_houre) {
        this.pricePerHoure = price_per_houre;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result
                + ((carModel == null) ? 0 : carModel.hashCode());
        result = prime * result + pricePerHoure;
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
        Car other = (Car) obj;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (carModel == null) {
            if (other.carModel != null)
                return false;
        } else if (!carModel.equals(other.carModel))
            return false;
        if (pricePerHoure != other.pricePerHoure)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", pricePerHoure=" + pricePerHoure +
                ", brand=" + brand +
                ", countOf=" + countOf +
                ", carId=" + carId +
                '}';
    }
}
