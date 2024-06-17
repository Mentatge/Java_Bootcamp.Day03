package ex01;

import java.util.concurrent.ArrayBlockingQueue;


public class Program {

    public static int count;
    public Boolean eggNext = true;
    ArrayBlockingQueue<Boolean> eggOrHen = new ArrayBlockingQueue<>(1);

    public synchronized void Egg() throws InterruptedException {
        for (int i = 0; i < count; i++) {
            while (!eggNext) {
                wait();
            }
            eggOrHen.put(true);
            System.out.println("Egg");
            eggNext = false;
            notify();
        }
    }

    public synchronized void Hen() throws InterruptedException {
        for (int i = 0; i < count; i++) {
            while (eggNext) {
                wait();
            }
            eggOrHen.take();
            System.out.println("Hen");
            eggNext = true;
            notify();
        }
    }


    public static void main(String[] args) {

        Program program = new Program();

        if (args.length == 0) {
            System.out.println("Entry count and try again");
            return;
        }
        args[0] = args[0].replaceAll("--count=", "");
        count = Integer.parseInt(args[0]);
        Thread egg = new Thread(() -> {
            try {
                program.Egg();
            } catch (InterruptedException e) {
                e.getLocalizedMessage();
            }
        });
        Thread hen = new Thread(() -> {
            try {
                program.Hen();
            } catch (InterruptedException e) {
                e.getLocalizedMessage();
            }
        });
        egg.start();
        hen.start();
    }
}
