package BaiTapXXI;

public class Bai2 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int sum = 0;
            for (int i = 1; i <= 1000; i++) {
                sum += i;
            }
            System.out.println("Tổng từ 1 đến 1000 là: " + sum);
        });
        thread.start();

    }
}
