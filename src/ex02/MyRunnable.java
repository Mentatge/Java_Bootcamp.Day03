package ex02;

import java.util.Arrays;

public class MyRunnable extends Thread {
    private final int[] array;
    private final int startIndex;
    private final int endIndex;
    private int sum;

    public MyRunnable(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        sum = Arrays.stream(array, startIndex, endIndex).sum();
    }

    public int getSum() {
        return sum;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
}
