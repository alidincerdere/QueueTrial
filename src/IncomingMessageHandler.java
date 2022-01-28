import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IncomingMessageHandler {

    private BlockingQueue<Message> messageQueue;

    ExecutorService executor = Executors.newSingleThreadExecutor();

    public IncomingMessageHandler() {
        messageQueue = new ArrayBlockingQueue(1000);
        MessageProcessor messageProcessor = new MessageProcessor(messageQueue);

        executor.execute(messageProcessor);

    }

    public void handle(Message message) {
        messageQueue.add(message);
    }
}
