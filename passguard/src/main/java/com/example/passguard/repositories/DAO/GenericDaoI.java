package com.example.passguard.repositories.DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T, ID extends Serializable> {
    T findById(Class<T> tClass, ID id);
    List<T> findAll(Class<T> tClass);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
}