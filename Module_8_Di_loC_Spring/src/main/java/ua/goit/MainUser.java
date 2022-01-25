package ua.goit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import ua.goit.model.User;
import ua.goit.model.UserRepository;

import java.util.List;
import java.util.Optional;

@ComponentScan
@EnableJpaRepositories
public class MainUser {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainUser.class);

        UserRepository repository = context.getBean(UserRepository.class);
//        Optional<User> byId = repository.findById(1L);
//        if(byId.isPresent()) {
//            System.out.println(byId.get());
//        }
        List<User> users = repository.findAll();
        users.forEach(System.out::println);
    }

}
