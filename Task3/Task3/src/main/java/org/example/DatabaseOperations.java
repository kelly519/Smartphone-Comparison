package org.example;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class DatabaseOperations<T> {


    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Class<T> entityClass;

    public DatabaseOperations(Class<T> entityClass) {
        this.entityClass = entityClass;
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/task2");
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "");
        properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        entityManagerFactory = Persistence.createEntityManagerFactory("SmartphonePU", properties);
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void closeEntityManager() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public void addEntity(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public List<T> getAllEntities() {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    public T getEntityById(Long id) {
        return entityManager.find(entityClass, id);
    }

    public void updateEntity(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
    }

    public void deleteEntity(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entity);
        transaction.commit();
    }
}