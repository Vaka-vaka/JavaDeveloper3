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
        Optional<Skills> byId = skillsRepository.findById(1L);
        if(byId.isPresent()) {
            System.out.println(byId.get().getLevel_skills() + " - "+ byId.get().getLanguage());
        }

//        Optional<User> byId = repository.findById(1L);
//        if(byId.isPresent()) {
//            System.out.println(byId.get());
//        }
//        List<Developers> users = repository.findAll();
//        users.forEach(System.out::println);


    }

}
