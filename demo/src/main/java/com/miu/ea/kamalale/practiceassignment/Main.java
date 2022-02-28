package com.miu.ea.kamalale.practiceassignment;

import com.miu.ea.kamalale.practiceassignment.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("personPU");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        initializeData();

        System.out.println("-------------------------------------------------------");

        TypedQuery<Factory> query1 = entityManager.createNamedQuery("Factory.findFactoryByYearGreaterThan", Factory.class);
        query1.setParameter("year",1985);
        List<Factory> factoryList = query1.getResultList();
        factoryList.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        //3- Write a query to return all people with a car with millage less than 100000 and produced by a factory
        // insured by an insurance company in CA. (using criteria API)
        CriteriaBuilder criBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Vechile> criQuery1 = criBuilder.createQuery(Vechile.class);
        Root<Vechile> rootVehicle = criQuery1.from(Vechile.class);
        criQuery1.select(rootVehicle.get("person"));
        Root<Car> car = criBuilder.treat(rootVehicle, Car.class);
        Predicate millagePredicate1 = criBuilder.greaterThan(car.get("millage"), 100000);
        Predicate factoryPredicate1 = criBuilder.equal(rootVehicle.get("factory").get("insurance")
                .get("address")
                .get("state"), "CA");
        Predicate andPredicate1 = criBuilder.and(millagePredicate1, factoryPredicate1);
        criQuery1.where(andPredicate1);
        TypedQuery<Vechile> personTypedQuery = entityManager.createQuery(criQuery1);
        System.out.println(personTypedQuery.getResultList());
        System.out.println("-------------------------------------------------------");

        TypedQuery<Vechile> query3 = entityManager.createNamedQuery("Person.findVechileByPerson", Vechile.class);
        query3.setParameter("name","Jack");
        List<Vechile> vechileList = query3.getResultList();
        vechileList.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        TypedQuery<Vechile> query4 = entityManager.createNamedQuery("Vechile.findAllCars",Vechile.class);
        //query3.setParameter("name","Jack");
        List<Vechile> carsList = query4.getResultList();
        carsList.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        CriteriaQuery<Vechile> criQuery2 = criBuilder.createQuery(Vechile.class);
        TypedQuery<Vechile> query6 = entityManager.createQuery(criQuery2);
        List<Vechile> vechileList2 = query6.getResultList();
        vechileList2.forEach(System.out::println);



    }
    private static void initializeData() {
        entityManager.getTransaction().begin();

        Car car1 = new Car(2000,18900);
        Car car2 = new Car(2020,10020);
        Car car3 = new Car(1999,120398);
        Car car4 = new Car(2000,123452);
        Van van1 = new Van(2000,Color.RED);
        Van van2 = new Van(2003,Color.BLUE);

        Person person1 = new Person("Jack",32);
        Person person2 = new Person("John",33);
        Person person3 = new Person("Jill",28);

        person1.addToVechileList(car1);
        person1.addToVechileList(car2);
        person1.addToVechileList(van2);
        person2.addToVechileList(car3);
        person3.addToVechileList(car4);
        person3.addToVechileList(van1);


        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);

        Address address1 = new Address("1102 E Chapman Ave","CA","Fullerton");
        Address address2 = new Address("5425 New Ballas Rd UNIT 214","MO","Creve Coeur");

        Insurance stateFarm = new Insurance("statefarm",address1);
        Insurance goodOnes = new Insurance("GoodOnes",address2);

        Factory factory1 = new Factory(1990,12300,stateFarm);
        Factory factory2 = new Factory(1980,800,stateFarm);
        Factory factory3 = new Factory(2000,20034,goodOnes);

        factory1.addVechiles(car1);
        factory1.addVechiles(car4);
        factory2.addVechiles(car3);
        factory2.addVechiles(van1);
        factory3.addVechiles(car2);
        factory3.addVechiles(van2);

        entityManager.getTransaction().commit();
    }

//    private static void initializeData2() {
//        entityManager.getTransaction().begin();
//
//        Car car1 = new Car(2000,18900);
//        Car car2 = new Car(2020,10020);
//        Car car3 = new Car(1999,120398);
//        Car car4 = new Car(2000,123452);
//        Van van1 = new Van(2000,Color.RED);
//        Van van2 = new Van(2003,Color.BLUE);
//
//        Person person1 = new Person("Jack",32);
//        Person person2 = new Person("John",33);
//        Person person3 = new Person("Jill",28);
//        person1.setVechileList(Arrays.asList(car1,car2,van2));
//        person2.setVechileList(Arrays.asList(car3));
//        person3.setVechileList(Arrays.asList(car4,van1));
//        car1.setPerson(person1);
//        car2.setPerson(person1);
//        car3.setPerson(person2);
//        car4.setPerson(person3);
//        van1.setPerson(person3);
//        van2.setPerson(person1);
//
//
//        entityManager.persist(person1);
//        entityManager.persist(person2);
//        entityManager.persist(person3);
//
//        Address address1 = new Address("1102 E Chapman Ave","CA","Fullerton");
//        Address address2 = new Address("5425 New Ballas Rd UNIT 214","MO","Creve Coeur");
//
//        Insurance stateFarm = new Insurance("statefarm",address1);
//        Insurance goodOnes = new Insurance("GoodOnes",address2);
//
//        Factory factory1 = new Factory(1990,12300,stateFarm);
//        Factory factory2 = new Factory(1980,800,stateFarm);
//        Factory factory3 = new Factory(2000,20034,goodOnes);
//
//        factory1.setVechiles(Arrays.asList(car1,car4));
//        factory2.setVechiles(Arrays.asList(van1,car3));
//        factory3.setVechiles(Arrays.asList(car2,van2));
//
//
//
//        entityManager.getTransaction().commit();
//    }
}
