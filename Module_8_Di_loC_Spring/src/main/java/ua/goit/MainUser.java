package ua.goit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.goit.model.Developers;
import ua.goit.model.Skills;
import ua.goit.repositories.SkillsRepository;
import ua.goit.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@ComponentScan
@EnableJpaRepositories
public class MainUser {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainUser.class);

        UserRepository repository = context.getBean(UserRepository.class);
        SkillsRepository skillsRepository = context.getBean(SkillsRepository.class);
        Optional<Developers> developers = repository.findById(1L);
        if(developers.isPresent()) {
            Developers developers1 = developers.get();
            System.out.println("Name - " + developers1.getName_());
            developers1.setName_("Valera");
            repository.save(developers1);
        }

        Optional<Developers> developers2 = repository.findById(1L);
        if(developers.isPresent()) {
            Developers developers1 = developers.get();
            System.out.println("Name after - " + developers1.getName_());

//        Optional<User> byId = repository.findById(1L);
//        if(byId.isPresent()) {
//            System.out.println(byId.get());
//        }
//        List<Developers> users = repository.findAll();
//        users.forEach(System.out::println);

        }
    }

}
