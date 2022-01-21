package ua.goit;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //метод 2
@Primary //инжект метод 3
@Scope("prototype")
public class MessageServiceImpl implements MessageService {

    private String message = "Hello from service";

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }


}
