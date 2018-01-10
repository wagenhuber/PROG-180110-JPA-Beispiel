package com.sabel.jpabeispiel;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;


    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int alter) {
        this.name = name;
        this.age = alter;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setAge(int alter) {
        this.age = alter;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(adresse, person.adresse);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, adresse);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", adresse=" + adresse +
                '}';
    }
}
