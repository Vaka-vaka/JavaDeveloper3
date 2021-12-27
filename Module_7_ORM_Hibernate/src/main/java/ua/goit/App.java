package ua.goit;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ua.goit.model.Users;

import java.io.Serializable;
import java.util.List;

public class App {

    public static void main( String[] args ) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();

//        try (Session session = factory.openSession()) {
//            session.beginTransaction();
//            Users users = new Users();
//            users.setName ("hiberName111");
//            users.setDescription("Users created through hibernate111");
//            users.setPassword("12311");
//            users.setId(2L);
//            Serializable id = session.save(users);
//            System.out.println(id);
//            session.getTransaction().commit();
//        }

        // все юзери
//        try (Session session = factory.openSession()) {
//            Query<Users> query = session.createQuery("from Users", Users.class);
//            List<Users> list = query.list();
//            list.forEach(System.out::println);

            //все юзери метод 2
            try (Session session = factory.openSession()) {
                Query<Users> query = session.createNativeQuery("select * from users", Users.class);
                List<Users> list = query.list();
                list.forEach(System.out::println);

        }

    }
}
