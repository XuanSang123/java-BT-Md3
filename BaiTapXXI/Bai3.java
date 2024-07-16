package BaiTapXXI;

public class Bai3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 2; i <= 100; i += 2) {
                System.out.print(i + " ");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                System.out.print(i + " ");
            }
        });
        thread1.start();
        thread2.start();
    }
}
