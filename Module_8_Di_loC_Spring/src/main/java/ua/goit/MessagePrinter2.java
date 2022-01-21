package ua.goit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter2 {

    @Autowired
    private  MessageService messageService;

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }

}
