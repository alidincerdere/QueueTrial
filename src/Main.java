public class Main {

    public static void main(String [] args) {
        System.out.println("hey");

        IncomingMessageHandler incomingMessageHandler = new IncomingMessageHandler();

        for (int i=0; i<10; i++) {

            Message message = new Message("message number " + i);

            incomingMessageHandler.handle(message);

        }
    }
}
