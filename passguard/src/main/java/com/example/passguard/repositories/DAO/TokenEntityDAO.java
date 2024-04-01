package com.example.passguard.repositories.DAO;

import com.example.passguard.repositories.entities.TokenEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TokenEntityDAO implements CrudRepository<TokenEntity, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<TokenEntity> findByToken(String token) {
        TypedQuery<TokenEntity> query = entityManager.createQuery(
                "SELECT t FROM TokenEntity t WHERE t.token = :token", TokenEntity.class);
        query.setParameter("token", token);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public <S extends TokenEntity> S save(S entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends TokenEntity> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> savedEntities = new ArrayList<>();
        for (S entity : entities) {
            savedEntities.add(save(entity));
        }
        return savedEntities;
    }

    @Override
    public Optional<TokenEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(TokenEntity.class, id));
    }

    public List<TokenEntity> findByUserId(Long userId) {
        TypedQuery<TokenEntity> query = entityManager.createQuery(
                "SELECT t FROM TokenEntity t WHERE t.userId = :userId", TokenEntity.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<TokenEntity> findAll() {
        return entityManager.createQuery("SELECT e FROM TokenEntity e", TokenEntity.class).getResultList();
    }

    @Override
    public Iterable<TokenEntity> findAllById(Iterable<Long> ids) {
        List<TokenEntity> foundEntities = new ArrayList<>();
        for (Long id : ids) {
            findById(id).ifPresent(foundEntities::add);
        }
        return foundEntities;
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(e) FROM TokenEntity e", Long.class).getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Override
    public void delete(TokenEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        for (Long id : ids) {
            deleteById(id);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends TokenEntity> entities) {
        for (TokenEntity entity : entities) {
            delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM TokenEntity").executeUpdate();
    }
}
