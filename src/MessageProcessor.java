import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MessageProcessor implements Runnable{

    private BlockingQueue<Message> messageQueue;

    public MessageProcessor(BlockingQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {

        while (true) {
            Message currentMessage = null;
            try {
                currentMessage = messageQueue.poll(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(currentMessage !=null) {
                System.out.println(currentMessage.getContent());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
