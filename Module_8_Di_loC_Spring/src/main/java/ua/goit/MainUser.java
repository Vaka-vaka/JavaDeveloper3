package ua.goit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.goit.service.UserService;

@ComponentScan
@EnableJpaRepositories
public class MainUser {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainUser.class);

        UserService service = context.getBean(UserService.class);
        service.printAllUsers();
        service.printGetUsers();


        }
    }

