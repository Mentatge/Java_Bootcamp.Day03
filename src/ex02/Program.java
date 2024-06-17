package ex02;

public class Program {
    public static int startIndexThreads = 0;
    public static int endIndexThreads = 0;
    public static int[] arr;

    public static void main(String[] args) {
        Validator validator = new Validator();
        if (!validator.Validation_string(args)) {
            return;
        }
        int countArray = Integer.parseInt(args[0].replace("--arraySize=", ""));
        int countThreads = Integer.parseInt(args[1].replace("--threadsCount=", ""));
        if (!validator.Validation_count(countArray, countThreads)) {
            return;
        }
        DoAll(countArray, countThreads);
    }

    private static void DoAll(int countArray, int countThreads) {
        arr = RandomArray.randomArray(countArray);
        System.out.println("Sum: " + arr.length);
        int ElementsForThreads = countArray / countThreads;
        MyRunnable[] threads = new MyRunnable[countThreads];
        for (int i = 0; i < countThreads; i++) {
            if (i != countThreads - 1) {
                endIndexThreads = ElementsForThreads + startIndexThreads;
            } else {
                endIndexThreads = countArray - 1;
            }
            threads[i] = new MyRunnable(arr, startIndexThreads, endIndexThreads);
            threads[i].start();
            startIndexThreads = endIndexThreads + 1;
        }
        for (MyRunnable thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.getLocalizedMessage();
            }
        }
        int sumByThreads = 0;
        int count = 0;
        for (MyRunnable thread : threads) {
            sumByThreads += thread.getSum();
            System.out.println("Thread " + ++count + ": " + "from " + thread.getStartIndex() + " to " + thread.getEndIndex() + " sum " + thread.getSum());
        }
        System.out.println("Sum by threads: " + sumByThreads);
    }
}
