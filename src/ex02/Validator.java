package ex02;

public class Validator {

    String arraySize = "--arraySize=";
    String threadSize = "--threadsCount=";

    public Boolean Validation_string(String[] argc) {
        if (argc.length > 2) {
            System.out.println("Error: Too many arguments");
            return false;
        }
        if (!argc[0].startsWith(arraySize)) {
            System.out.println("Error: Invalid argument " + argc[0]);
            System.out.println("Try again with " + arraySize);
            return false;
        }
        if (!argc[1].startsWith(threadSize)) {
            System.out.println("Error: Invalid argument " + argc[1]);
            System.out.println("Try again with " + threadSize);
            return false;
        }
        return true;
    }

    public Boolean Validation_count(int count_array, int count_threads) {
        if (count_threads > count_array) {
            System.out.println("Error: Too many threads");
            return false;
        }
        if (count_threads == 0) {
            System.out.println("Error to few threads");
            return false;
        }
        if (count_threads > 1000) {
            System.out.println("Error: Too many threads");
            return false;
        }
        if (count_array > 2000000) {
            System.out.println("Error: Too many arrays");
            return false;
        }
        return true;
    }
}
