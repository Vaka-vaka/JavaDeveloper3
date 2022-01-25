package ua.goit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import ua.goit.model.User;

import java.util.List;

@ComponentScan
@EnableScheduling
@Configuration
public class MainUser {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainUser.class);

        JdbcTemplate template = context.getBean(JdbcTemplate.class);
//        List<String> name_ = template.query("select * from developers"
//                , (rs, rowNum) -> rs.getString("id") + " - " + rs.getString("name_"));
//        System.out.println(name_);

        User user = template.queryForObject("select * from developers where id = 1",
                User.class);
        System.out.println(user);
    }
}
