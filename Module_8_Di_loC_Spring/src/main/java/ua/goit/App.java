package ua.goit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class App {

    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        MessagePrinter messageProvide = context.getBean(MessagePrinter.class);
      //  MessageService messageService = (MessageService) context.getBean("messageService");
       // System.out.println(messageService.getMessage()); //1 спосіб
        messageProvide.printMessage(); //2 спосіб
    }
}
