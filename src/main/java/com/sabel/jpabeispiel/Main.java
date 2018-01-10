package com.sabel.jpabeispiel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Wagenhuber", 32);
        person.setAdresse(new Adresse("Ahornstr.", "8", 83253, "Rimsting"));

        Person person2 = new Person("Moosgruber", 44);
        person2.setAdresse(new Adresse("Ahornstr.", "9", 83253, "Rimsting"));

        Person person3 = new Person("Wagengruber", 55);
        person3.setAdresse(new Adresse("Ahornstr.", "10", 83253, "Rimsting"));

        PersonService personService = new PersonService();
        personService.speichern(person);
        personService.speichern(person2);
        personService.speichern(person3);

        Person personAusDB = personService.findePerson(2);
        System.out.println("Person anzeigen:");
        if (personAusDB != null) {
            System.out.println(personAusDB);
        }

        List<Person> personen = personService.gibAllePersonen();
        System.out.println("Alle Personen aus dB ausgeben:");
        for (Person person1 : personen) {
            System.out.println(person1);
        }

        personService.close();
    }

}
