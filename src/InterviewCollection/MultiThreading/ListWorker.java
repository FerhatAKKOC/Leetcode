package InterviewCollection.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListWorker {

    Random random = new Random();

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void list1DegerEkle() {

        synchronized (lock1) {

            list1.add(random.nextInt(100));

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void list2DegerEkle() {

        synchronized (lock2) {
            list2.add(random.nextInt(100));

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void degerAta() {

        for (int i = 0; i < 1000; i++) {
            list1DegerEkle();
            list2DegerEkle();
        }
    }

    public void calistir() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                degerAta();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                degerAta();
            }
        });


        long start = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List1 Size : " + list1.size() + "  List2 Size: " + list2.size());

        long end = System.currentTimeMillis();
        System.out.println("Geçen Süre: " + (end - start));
    }

}
