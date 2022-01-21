package ua.goit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //метод 3
public class Config {

    @Bean
    MessageService getMessageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "Hello from Valentyn";
            }
        };
    }
}
