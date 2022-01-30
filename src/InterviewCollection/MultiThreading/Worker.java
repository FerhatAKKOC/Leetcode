package InterviewCollection.MultiThreading;

public class Worker  implements Runnable{

    private String isim;
    private int taskId;

    public Worker(String isim, int taskId) {
        this.isim = isim;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Worker " + isim + " " + taskId + ". Start...");
            Thread.sleep(5000);
            System.out.println("Worker " + isim + " " + taskId + ". End...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
