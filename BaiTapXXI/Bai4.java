package BaiTapXXI;

public class Bai4 {
    public static void main(String[] args) {
//        Tạo lớp NumberGenerator triển khai interface Runnable với phương thức run thực hiện một vòng lặp in ra 10 số tự nhiên đầu tiên và mỗi lần in cách nhau 500 milliseconds, cùng với thông tin hashCode của bản thân generator.
//
//Tạo 2 object của class Thread với tham số khởi tạo là 2 đối tượng NumberGenerator.
//
//Gọi phương thức start() cho cả 2 thread.
//
//Thử thay đổi priority của 2 thread, chẳng hạn Thread.MAX_PRIORITY và Thread.MIN_PRIORITY và chạy lại chương trình.
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();
        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
    }
}