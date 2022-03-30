package com.miu.ea.kamalale.exam1;

import com.miu.ea.kamalale.exam1.entities.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("moviePU");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        initializeData();
        printSeparator();
        findPersonInMovie("The Matrix");
        printSeparator();
        findMovieWithActorInParticularStateAndYear("CA",1997);
        printSeparator();
        findAllActorsInAState("CA");
        printSeparator();
        updateAge();
    }

    private static void updateAge() {
        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("select p from Person p where p.name like '%Carrie%'");
        List<Person> personList = q.getResultList();
        personList.get(0).setAge(55);
        entityManager.getTransaction().commit();
        List<Person> personList2 = q.getResultList();
        System.out.println("Carrie new Age is "+personList2.get(0).getAge());
    }

    private static void findMovieWithActorInParticularStateAndYear(String stateName, int year) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
        Root<Movie> rootMovie = cq.from(Movie.class);
        Root<Person> rootPerson = cq.from(Person.class);
        Root<Actor> rootActor = cb.treat(rootPerson,Actor.class);
        Predicate statePredicate = cb.equal(rootActor.get("address").get("state"),stateName);
        Predicate yearPredicate = cb.greaterThan(rootMovie.get("year"),year);
        Predicate andPredicate = cb.and(statePredicate,yearPredicate);
        cq.where(andPredicate);
        TypedQuery<Movie> movieTypedQuery = entityManager.createQuery(cq);
        List<Movie> movieList = movieTypedQuery.getResultList();
        HashSet<Movie> movieHashSet = new HashSet<>();
        movieHashSet.addAll(movieList);
        System.out.println("Movies after year 1997 and having a actor living in CA ::");
        movieHashSet.forEach(System.out::println);
    }

    private static void findMovieWithActorInParticularStateAndYear2(String stateName, int year) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
        Root<Movie> rootMovie = cq.from(Movie.class);
        Root<Person> rootPerson = cq.from(Person.class);
        Root<Actor> rootActor = cb.treat(rootPerson,Actor.class);
        Join<Movie,Actor> joinActor = rootMovie.joinCollection("personList");
        Predicate statePredicate = cb.equal(joinActor.get("address").get("state"),stateName);
        Predicate yearPredicate = cb.greaterThan(rootMovie.get("year"),year);
        Predicate andPredicate = cb.and(statePredicate,yearPredicate);
        cq.where(andPredicate);
        TypedQuery<Movie> movieTypedQuery = entityManager.createQuery(cq);
        List<Movie> movieList = movieTypedQuery.getResultList();
        System.out.println("Movies after year 1997 and having a actor living in CA ::");
        movieList.forEach(System.out::println);
    }

    private static void findAllActorsInAState(String stateName) {
        TypedQuery<Actor> query = entityManager.createNamedQuery("Person.findAllActorInAState",Actor.class);
        query.setParameter("state",stateName);
        query.setParameter("actor",Actor.class);
        List<Actor> actorList = query.getResultList();
        System.out.println("All actors in state CA::");
        actorList.forEach(System.out::println);
    }

    private static void printSeparator() {
        System.out.println();
        System.out.println("*********************************************************************************");
    }

    private static void findPersonInMovie(String movieTitle) {
        TypedQuery<Person> query = entityManager.createNamedQuery("Movie.findPersonsByMovie",Person.class);
        query.setParameter("title",movieTitle);
        List<Person> personList = query.getResultList();
        System.out.println("All Persons in movie Titanic");
        personList.forEach(System.out::println);
    }

    private static void initializeData() {
        entityManager.getTransaction().begin();

        Address address1 = new Address("9601 Wilshlre Blvd.","Beverly Hills","CA");
        Address address2 = new Address("United Agents Ltd.","London","England");
        Address address3 = new Address("2000 Avenue Of The Stars","Century City","CA");
        Address address4 = new Address("1625 WilShire Blvd","Los Angeles","CA");
        Address address5 = new Address("10207 Lakewood Blvd","Downey","CA");

        Actor keanu = new Actor("Keanu Reeves",57, Gender.MALE,38);
        Actor carrie = new Actor("Carrie Anne Moss",50, Gender.FEMALE,33);
        Actor kate = new Actor("Kate Winslet",46, Gender.FEMALE,31);
        Actor leo = new Actor("Leonardo DiCaprio",47, Gender.MALE,42);

        Stunt shea = new Stunt("Shea Adams",35,5.6f,150);
        Stunt bob = new Stunt("Bob Bowles",28,5.5f,120);

        address1.addPersonToList(keanu);
        address1.addPersonToList(carrie);
        address2.addPersonToList(kate);
        address3.addPersonToList(leo);
        address4.addPersonToList(shea);
        address5.addPersonToList(bob);

        Movie movie1 = new Movie("The Titanic",1999, Arrays.asList(keanu,carrie,shea));
        Movie movie2 = new Movie("The Matrix",1997, Arrays.asList(kate,leo,bob));

        entityManager.persist(movie1);
        entityManager.persist(movie2);
        entityManager.getTransaction().commit();
    }
}
