package InterviewCollection.MultiThreading;

import java.util.Scanner;

public class WaitNotify {

    private Object lock = new Object();

    public void thread1Fonksiyonu() {


        synchronized (lock) {
            System.out.println("Thread 1 Çalışıyor...");
            System.out.println("Thread 1 , Thread 2 nin kendisini uyandırmasını bekliyor...");

            try {
                lock.wait();    // Anahtarı teslim edecem, başka biri beni uyandırana kadar bekleyecem.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 1 uyandı. Devam ediyor...");
        }
    }

    public void thread2Fonksiyonu() {
        try {

            Scanner scanner = new Scanner(System.in);
            Thread.sleep(2000);

            synchronized (lock) {

                System.out.println("Thread 2 çalışıyor, devam etmek için bir tuşa basınız...");
                scanner.nextLine();

                lock.notify();   // notify'ın işleyebilmesi için bu kod bloğundan çıkması gerekir.
                System.out.println("Uyandırdım abi, ben gidiyorum....");

                Thread.sleep(2000);


            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
