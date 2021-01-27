package Aumain;

import entity.Address;
import entity.Courses;
import entity.Employee;
import entity.PersonalDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDemo {
    public static void main(String[] args) throws Exception{
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Courses.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(PersonalDetails.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Address address1 = new Address("T Nagar", "Chennai", 600025);
        Address address2 = new Address("Thiruvandipuram", "Cuddalore", 607401);
        Courses courses1 = new Courses();
        Courses courses2 = new Courses();
        courses1.setCourseName("Spring MVC Afternoon");
        courses2.setCourseName("Spring Core Forenoon");
        Employee employee1 = new Employee("kalai", "chelvan");
        Employee employee2 = new Employee("kannan", "m");
        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);

        PersonalDetails personalDetails1 = new PersonalDetails("k@gmail.com", "992218", employee1);
        PersonalDetails personalDetails2 = new PersonalDetails("chelvan@gmail.com", "827399", employee2);


        Set<Address> employee1Address = new HashSet<>();
        employee1Address.add(address1);
        employee1Address.add(address2);
        employee1.setAddresses(employee1Address);

        Set<Courses> courses = new HashSet<>();
        courses.add(courses1);
        courses.add(courses2);

        // ManyToMany
        employee1.setCoursesSet(courses);
        employee2.setCoursesSet(courses);
        courses1.setEmployeeSet(employees);
        courses2.setEmployeeSet(employees);

        try{
            session.beginTransaction();
            session.save(courses1);
            session.save(courses2);
            session.save(employee1);
            session.save(employee2);
            session.save(personalDetails1);
            session.save(personalDetails2);
            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}