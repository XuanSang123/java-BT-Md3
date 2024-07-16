package BaiTapXXI;

public class Bai9 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                for (int i = 10; i > 0; i--) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
                System.out.println("Kết thúc");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
