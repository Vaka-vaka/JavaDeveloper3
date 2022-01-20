package ua.goit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main( String[] args ) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("my-beam.xml");
        MessagePrinter messageProvide = (MessagePrinter) context.getBean("messagePrinter");
        MessageService messageService = (MessageService) context.getBean("messageService");
        System.out.println(messageService.getMessage()); //1 спосіб
        messageProvide.printMessage(); //2 спосіб
    }
}
