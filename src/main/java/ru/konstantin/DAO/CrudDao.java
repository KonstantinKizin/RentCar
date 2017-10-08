package ru.konstantin.DAO;
import java.util.List;

public interface CrudDao<T,V> {

    T get(V v);

    List<T> getAll();

    T deleteByObject(T t);

    void update(T t);

    void add(T t);






}
