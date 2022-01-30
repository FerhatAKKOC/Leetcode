package InterviewCollection.MultiThreading;

public class ListWorkerMain {

    public static void main(String[] args) {

        ListWorker worker = new ListWorker();

        worker.calistir();

/*        long start = System.currentTimeMillis();
        worker.degerAta();
        long end = System.currentTimeMillis();

        System.out.println("Geçen süre : " + (end - start));*/

    }
}
