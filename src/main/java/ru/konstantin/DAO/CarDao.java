package ru.konstantin.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.konstantin.Models.Car;

import java.util.List;

public class CarDao implements CrudDao<Car , Long> {

    private final SessionFactory sessionFactory = new Configuration()
            .configure()
            .buildSessionFactory();

    @Override
    public Car get(Long id) {

        Car car = null;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            car = session.get(Car.class , id);
            session.getTransaction().commit();
        }
        return car;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            cars = session.createQuery(" FROM Car").list();
            session.getTransaction().commit();
        }

        return cars;
    }

    @Override
    public Car deleteByObject(Car car) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        }
        return car;
    }


    @Override
    public void update(Car car) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(car);
            session.getTransaction().commit();
        }

    }

    @Override
    public void add(Car car) {

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        }
    }

    SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }


}
