package com.alegerd.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public class GenericDao<T, PK extends Serializable> {

    @PersistenceContext
    private EntityManager manager;

    private Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T find(PK pk) {
        return manager.find(entityClass, pk);
    }

    public List<T> getAll() {
        return manager.createQuery("from " + entityClass.getSimpleName()).getResultList();
    }

    public void create(T entity) {
        manager.persist(entity);
    }

    public T update(T entity) {
        return  manager.merge(entity);
    }

    public void delete(T entity) {
        manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
    }

    public EntityManager getManager(){return this.manager; }
}
