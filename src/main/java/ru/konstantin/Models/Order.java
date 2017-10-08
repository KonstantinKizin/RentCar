package ru.konstantin.Models;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    public void setClient(Client client) {
        this.client = client;
    }

    private  Client client;

    private OrderItem orderItem;

    private long id;

    @Column(name = "totalPrice")
    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    private float totalPrice;


    public Order(){

    }

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    public Client getClient() {
        return client;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public OrderItem getOrderItems() {
        return orderItem;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    public long getId() {
        return id;
    }




    public void setOrderItems(OrderItem orderItem) {
        this.orderItem = orderItem;
    }



    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", orderItems=" + orderItem +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (client != null ? !client.equals(order.client) : order.client != null) return false;
        return orderItem != null ? orderItem.equals(order.orderItem) : order.orderItem == null;
    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + (orderItem != null ? orderItem.hashCode() : 0);
        return result;
    }
}
