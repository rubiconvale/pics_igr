package com.picsauditing.data.domaindao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
public abstract class AbstractDaoImpl<E extends Serializable, K extends Serializable>  {

    protected final Logger log=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    protected Class<? extends E> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDaoImpl() {
        persistentClass = (Class<? extends E>) ((ParameterizedType) getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")

    public E create(E entity) {
        return (E) sessionFactory.getCurrentSession().save(entity);
    }


    public void persist(E entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public void update(E entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        sessionFactory.getCurrentSession().flush();
    }


    public void merge(E entity) {
        sessionFactory.getCurrentSession().merge(entity);
        sessionFactory.getCurrentSession().flush();
    }
    public void delete(E entity) {
        sessionFactory.getCurrentSession().delete(entity);

    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E find(K id) {
        return (E) sessionFactory.getCurrentSession().get(getPersistentClass(),id);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E findByEntity(E entity) {
        return (E) sessionFactory.getCurrentSession().get(getPersistentClass(),entity);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findAllObjects() {
        return findObjectsByCriteria();
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findObjectsByCriteria(Criterion... criterion) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    /**
     * @return the persistentClass
     */
    public Class<? extends E> getPersistentClass() {
        return persistentClass;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}