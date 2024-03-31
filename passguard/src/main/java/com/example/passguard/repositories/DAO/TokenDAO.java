package com.example.passguard.repositories.DAO;

import com.example.passguard.repositories.entities.TokenEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TokenDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public TokenDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveOrUpdateToken(TokenEntity tokenEntity) {
        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(tokenEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public TokenEntity getTokenByUserId(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(TokenEntity.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public TokenEntity getTokenByTokenValue(String tokenValue) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM TokenEntity WHERE token = :token", TokenEntity.class)
                    .setParameter("token", tokenValue)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void deleteTokenByUserId(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            TokenEntity tokenEntity = session.get(TokenEntity.class, userId);
            if (tokenEntity != null) {
                session.delete(tokenEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
