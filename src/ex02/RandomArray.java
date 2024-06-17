package ex02;

import java.util.Random;

public class RandomArray {
    private final static int maxValue = 1000;

    public static int[] randomArray(int sizeArray) {
        int[] randomArray = new int[sizeArray];
        Random random = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(2 * maxValue) - maxValue;
        }
        return randomArray;
    }
}
