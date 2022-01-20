package ua.goit;

public class MessagePrinter {

    private MessageService messageService;

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }


}
