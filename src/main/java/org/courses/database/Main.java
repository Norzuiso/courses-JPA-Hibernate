package org.courses.database;

import org.courses.database.dto.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg = cfg.configure("META-INF/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Employee firstEmployee = new Employee(1121,
                "Pedro",
                "Del Sagrado Corazón de Jesus",
                "Manager",
                120000
                );
        Employee secondEmployee = new Employee(1121,
                "Pablo",
                "Amiguos",
                "Analyst",
                100000
        );

        Transaction transaction = session.beginTransaction();

        session.save(firstEmployee);
        session.save(secondEmployee);

        transaction.commit();

        session.close();
        factory.close();
    }
}