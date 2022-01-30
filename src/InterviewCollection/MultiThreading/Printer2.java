package InterviewCollection.MultiThreading;

public class Printer2 implements Runnable{

    private String isim;

    public Printer2(String isim) {
        this.isim = isim;
    }

    @Override
    public void run() {
        System.out.println(isim + " çalışıyor");

        for (int i = 0; i < 10; i++) {
            System.out.println(isim + " Yazıyor : " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(isim + " kesintiye uğradı...");
            }
        }

        System.out.println(isim + " işini bitirdi...");
    }
}
