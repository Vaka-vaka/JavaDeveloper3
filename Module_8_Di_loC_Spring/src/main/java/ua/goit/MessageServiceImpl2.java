package ua.goit;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("messageService2")  //метод 1
public class MessageServiceImpl2 implements MessageService {

    @Override
    public String getMessage() {
        return "Hello from service 2";
    }
}
