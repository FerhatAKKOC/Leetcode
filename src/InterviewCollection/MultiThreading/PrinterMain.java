package InterviewCollection.MultiThreading;

public class PrinterMain {

    public static void main(String[] args) {

        System.out.println("Main Thread çalışıyor");

        // Extended Threads
/*        Printer1 printer1 = new Printer1("Printer1");
        Printer1 printer2 = new Printer1("Printer2");
        printer1.start();
        printer2.start();*/

        // Implemented Thread
/*        Thread printer1 = new Thread(new Printer2("printer1"));
        Thread printer2 = new Thread(new Printer2("printer2"));
        printer1.start();
        printer2.start();*/

        // Anonynomous Thread
        Thread printer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread çalışıyor...");
                for (int i = 0; i < 10; i++) {
                    System.out.println("Yazıyor : " + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("kesintiye uğradı...");
                    }
                }
            }
        });
        printer1.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread çalışıyor...");
                for (int i = 0; i < 10; i++) {
                    System.out.println("Yazıyor : " + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("kesintiye uğradı...");
                    }
                }
            }
        }).start();
    }
}
