package com.dyrda.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sergiy on 28.07.2016.
 */

@Repository
@Transactional
public class HibernateUtil {

    @Autowired
    SessionFactory sessionFactory;

    public <T> Serializable createEntity(T entity) {
        return getCurrentSession().save(entity);
    }

    public <T> T updateEntity(T entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    public <T> void deleteEntity(Serializable id, Class<T> tClass) {
        T entity = getEntityById(id, tClass);
        deleteEntity(entity);
    }

    public <T> void deleteEntity(T entity) {
        getCurrentSession().delete(entity);
    }

    public <T> T getEntityById(Serializable id, Class<T> tClass) {
        return (T) getCurrentSession().get(tClass, id);
    }

    public <T> List<T> getAllEntities(Class<T> tClass) {
        return getCurrentSession().createQuery(" from " + tClass.getSimpleName()).list();
    }

    public List getEntitiesBySQLQuery(String query) {
        return getCurrentSession().createSQLQuery(query).list();
    }

    public <T> List<T> getEntitiesByEntityParam(Class<T> tClass, String paramName, String paramValue) {
        return getCurrentSession().
                  createQuery(" from " + tClass.getSimpleName() + " where " + paramName + " like '%" + paramValue + "%'")
                  .list();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
