package InterviewCollection.MultiThreading;

public class ProducerConsumerCustomMain {



    public static void main(String[] args) {

        ProducerConsumerCustom pcc = new ProducerConsumerCustom();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                pcc.produce();
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                pcc.consume();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
