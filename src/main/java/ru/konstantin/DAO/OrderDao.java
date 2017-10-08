package ru.konstantin.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.konstantin.Models.Order;

import java.util.List;

public class OrderDao implements CrudDao<Order, Long> {

    private final SessionFactory sessionFactory = new Configuration()
            .configure().buildSessionFactory();




    public Order get(Long integer) {

        Order order = null;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            order= session.get(Order.class , integer);
            session.getTransaction().commit();
        }
        return order;
    }


    public List<Order> getAll() {

        List<Order> orders = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            orders = session.createQuery(" FROM Order").list();
            session.getTransaction().commit();
        }

        return orders;
    }

    public Order deleteByObject(Order order) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
        }
        return order;
    }



    public void deleteById(Long integer) {

        long id = integer;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(id);
            session.getTransaction().commit();
        }
    }

    public void update(Order order) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        }
    }

    public void add(Order order) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
    }


   SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }
}
