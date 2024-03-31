package com.example.passguard.repositories.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/// GenericDao<User, Long> userDao = new GenericDaoJpa<>(User.class); example
@Repository
@Transactional
public class GenericDAO<T, ID extends Serializable> implements GenericDaoI<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    public T findById(Class<T> tClass, ID id) {
        return entityManager.find(tClass, id);
    }


    public List<T> findAll(Class<T> tClass) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(tClass);
        Root<T> rootEntry = cq.from(tClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }


    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}