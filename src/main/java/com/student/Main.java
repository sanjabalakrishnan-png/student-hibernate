package com.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Student student = session.get(Student.class, 100);

        student.setName("Sanjana");
        student.setEmail("sanjana@gmail.com");
        student.setCourse("Hibernate");

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

        System.out.println("Student updated successfully!");
    }
}