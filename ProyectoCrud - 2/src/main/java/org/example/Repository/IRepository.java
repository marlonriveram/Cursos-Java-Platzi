package org.example.Repository;

import org.example.model.Employees;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {
    List<T> findAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    void save (T data) throws SQLException;

    void delete (Integer id) throws SQLException;

    void update(Integer id, Employees employees) throws SQLException;
}
