package com.demo;

import jakarta.persistence.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePersistence")) {

            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            String q = "from Person";
            TypedQuery<Person> query = entityManager.createQuery(q, Person.class);
            List<Person> list = query.getResultList();
            System.out.println(list);

            Query nativeQuery = entityManager.createNativeQuery("select name from person");
            List list1 = nativeQuery.getResultStream().toList();
            System.out.println(list1);

//            transaction.commit();
            entityManager.close();
        }
    }
}
