package BaiTapXXI;
import java.util.Scanner;

public class Bai10 extends Thread {
    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of seconds to sleep: ");
            int seconds = scanner.nextInt();
            System.out.println("Sleeping for " + seconds + " seconds...");
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
            System.out.println("Awake!");
        } catch (InterruptedException e) {
            System.err.println("The thread was interrupted.");
        }
    }

    public static void main(String[] args) {
        BT10 thread = new BT10();
        thread.start();
    }
}