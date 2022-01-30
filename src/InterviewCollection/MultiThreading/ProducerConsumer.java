package InterviewCollection.MultiThreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    Random random = new Random();

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce() {
        while (true) {
            try {

                Thread.sleep(1000);
                var value = random.nextInt(100);
                queue.put(value);
                System.out.println("Producer Üretiyor: " + value);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() {

        while (true) {
            try {

                Thread.sleep(5000);
                var value = queue.take();
                System.out.println("Consumer Tüketiyor: " + value);
                System.out.println("Queue Size: " + queue.size());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
