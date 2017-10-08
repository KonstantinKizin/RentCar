package ru.konstantin.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.konstantin.Models.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDao implements CrudDao<Client,String> {

    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Override
    public Client get(String passportInfo) {
        Client client = null;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            client = session.get(Client.class,passportInfo);
            session.getTransaction().commit();
        }
        return client;
    }

    @Override
    public List<Client> getAll() {

        List<Client> clients = new ArrayList<>();

        return clients;
    }

    @Override
    public Client deleteByObject(Client client) {

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
        return client;
    }


    @Override
    public void update(Client client) {

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }

    }

    @Override
    public void add(Client client) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }


    }
}
