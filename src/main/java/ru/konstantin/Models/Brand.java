package ru.konstantin.Models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Brand implements Serializable {

    private String brand_name;

    private String producer;


    public Brand(){}

    @Column(name = "brand_name")
    public String getBrand_name() {
        return brand_name;
    }

    @Column(name = "producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }




    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        return brand_name != null ? brand_name.equals(brand.brand_name) : brand.brand_name == null;
    }

    @Override
    public int hashCode() {
        int result = brand_name != null ? brand_name.hashCode() : 0;
        result = 31 * result ;
        return result;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_name='" + brand_name + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
