package ua.goit;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component //метод 2
//@Primary //инжект метод 3
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage() {
        return "Hello from service";
    }
}
