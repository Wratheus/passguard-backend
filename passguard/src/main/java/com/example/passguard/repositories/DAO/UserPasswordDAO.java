package com.example.passguard.repositories.DAO;

import com.example.passguard.repositories.entities.UserPasswordEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserPasswordDAO implements CrudRepository<UserPasswordEntity, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <S extends UserPasswordEntity> S save(S entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends UserPasswordEntity> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> savedEntities = new ArrayList<>();
        for (S entity : entities) {
            savedEntities.add(save(entity));
        }
        return savedEntities;
    }

    @Override
    public Optional<UserPasswordEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(UserPasswordEntity.class, id));
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<UserPasswordEntity> findAll() {
        return entityManager.createQuery("SELECT e FROM UserPasswordEntity e", UserPasswordEntity.class).getResultList();
    }

    @Override
    public Iterable<UserPasswordEntity> findAllById(Iterable<Long> ids) {
        List<UserPasswordEntity> foundEntities = new ArrayList<>();
        for (Long id : ids) {
            findById(id).ifPresent(foundEntities::add);
        }
        return foundEntities;
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(e) FROM UserPasswordEntity e", Long.class).getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Override
    public void delete(UserPasswordEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        for (Long id : ids) {
            deleteById(id);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends UserPasswordEntity> entities) {
        for (UserPasswordEntity entity : entities) {
            delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM UserPasswordEntity").executeUpdate();
    }
}
