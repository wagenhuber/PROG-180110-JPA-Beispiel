package com.sabel.jpabeispiel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonService() {
        emf = Persistence.createEntityManagerFactory("personenverwaltung");
        em = emf.createEntityManager();
    }

    public void close(){
        if(em != null){
            em.close();
        }
        em = null;
        if (emf != null){
            emf.close();
        }
        emf = null;
    }

    public void speichern(Person person){
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        System.out.println(person.toString() + " in DB gespeichert!");
    }


    public Person findePerson(int id){
        return em.find(Person.class, id);

    }

    public List<Person> gibAllePersonen(){
        TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

}
