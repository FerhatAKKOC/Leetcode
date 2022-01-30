package InterviewCollection.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerMain {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++)
            executor.submit(new Worker(String.valueOf(i), i));

        executor.shutdown();  //  Main'i sonlandırmak için şart, Threadler bitmeden önce executer kapanmayacak.
        System.out.println("Bütün işler teslim edildi...");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);  // Threadlerde kitlenme ihtimaline karşı 1 gün sonra kapatıyoruz executor'u
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Bütün işler bitti....");


/*        Thread t1 = new Thread(new Worker("1", 1));
        Thread t2 = new Thread(new Worker("2", 2));
        Thread t3 = new Thread(new Worker("3", 3));
        Thread t4 = new Thread(new Worker("4", 4));
        Thread t5 = new Thread(new Worker("5", 5));

        System.out.println("Bütün işler teslim edildi...");

        try {

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            t3.start();
            t4.start();
            t3.join();
            t4.join();

            t5.start();
            t5.join();

            System.out.println("Bütün işler tamamlandı...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
