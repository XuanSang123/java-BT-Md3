package BaiTapXXI;

public class Bai7 {
    public static void main(String[] args) {
        RandomNumberThread randomNumberThread = new RandomNumberThread();
        randomNumberThread.start();
    }
}

class RandomNumberThread extends Thread {
    @Override
    public void run() {
        // Generate a random number and print it
        int randomNumber = (int) (Math.random() * 100); // Generate a random number between 0 and 99
        System.out.println("Random Number: " + randomNumber);
    }
}