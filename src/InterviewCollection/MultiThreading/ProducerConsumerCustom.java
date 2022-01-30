package InterviewCollection.MultiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerCustom {

    Random random = new Random();
    Object lock = new Object();

    Queue<Integer> queue = new LinkedList<>();
    private int limit = 10;

    public void produce() {
        try {

            while (true) {
                Thread.sleep(1000);

                synchronized (lock) {

                    if (queue.size() == limit)
                        lock.wait();
                    Integer value = random.nextInt(100);
                    queue.offer(value);
                    System.out.println("Producer Üretiyor: " + value);
                    lock.notify(); // Consumer uyuyorsa, onu uyandırıyoruz.
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() {

        try {

            while (true) {
                Thread.sleep(5000);

                synchronized (lock) {


                    if (queue.size() == 0){
                        lock.wait();
                    }

                    Integer value = queue.poll();
                    System.out.println("Consumer Tüketiyor: " + value);
                    System.out.println("Queue Size: " + queue.size());
                    lock.notify(); // wake up producer
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
