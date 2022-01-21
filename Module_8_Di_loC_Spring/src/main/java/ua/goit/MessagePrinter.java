package ua.goit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope
public class MessagePrinter {


   // @Qualifier("messageService2") //метод 1
//    private List< MessageService> messageServiceList; //метод 1 для getAll
//    private Map< String, MessageService> messageServiceMap; //метод 2 для getAll через Map
    @Autowired
    private  MessageService messageService;

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }
    public void changeMessage (String message) {
        messageService.setMessage(message);
        }

//    public MessagePrinter(MessageService messageService) {
//        this.messageService = messageService;
//    }

    //метод 1 для getAll
//    public void printMessage() {
//        messageServiceList.forEach(messageService -> {
//            System.out.println(messageService.getMessage());
//        });

//    public void printMessage() {
//        messageServiceMap.forEach(
//                (key, value) -> System.out.println(key + " - " + value.getMessage()));
      //  System.out.println(messageService.getMessage());


}
