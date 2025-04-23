import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProducersConsumer {
    public void blockingQueue() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        Random random = new Random();
        Supplier<String> producer = () -> "Message- " + random.nextInt(100);
        Consumer<String> consumer = message -> {
            String time = LocalTime.now().withNano(0).toString();
            System.out.println("{"+time+"}"+message);
        };
        new Thread(() -> {
            while (true) {
                try{
                   String message=producer.get();
                   queue.put(message);
                   Thread.sleep(2000);
                }catch (InterruptedException e) {}
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    String message = queue.take(); // blocks if queue is empty
                    consumer.accept(message);
                }catch (InterruptedException e) {}

            }
        }).start();

    }
}
