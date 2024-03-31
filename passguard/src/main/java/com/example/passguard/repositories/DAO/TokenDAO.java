package com.example.passguard.repositories.DAO;

import com.example.passguard.repositories.entities.TokenEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TokenDAO extends GenericDao<TokenEntity, Long> implements TokenDaoI {

    private final SessionFactory sessionFactory;

    @Autowired
    public TokenDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
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
}
