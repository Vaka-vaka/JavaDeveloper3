package ua.goit;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ua.goit.model.Users;

import java.io.Serializable;

public class App {

    public static void main( String[] args ) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Users users = new Users();
            users.setName ("hiberName");
            users.setDescription("Users created through hibernate");
            users.setPassword("123");
            users.setId(1000L);
            Serializable id = session.save(users);
            System.out.println(id);
            session.getTransaction().commit();
        }

    }
}
