package repository;

import entities.Utente;

import java.util.List;

public interface InterfaceDataSourceJPA<T, PK> {

    T findById(PK id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(PK id);

    T findBySomething(String query, Object value);

    List<T> findBySomethingList(String query, Object value);

    List<T> findByMore(String query, int nPar, Object[] values);

}
