package ex00;

public class Program {
    static int count;
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Program count");
            return;
        }
        args[0] = args[0].replace("--count=", "");
        count = Integer.parseInt(args[0]);
        Thread egg = new Egg(count);
        Thread hen = new Hen(count);
        egg.start();
        hen.start();
        try {
            egg.join();
            hen.join();
        } catch (InterruptedException e) {
            System.err.println("Something wrong " + e.getMessage());
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
