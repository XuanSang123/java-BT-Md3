package BaiTapXI.Bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //tạo 1 list số nguyên
        List<Integer> integerList = new ArrayList<Integer>();
        //thêm ngẫu nhiên 10 phần tử vào List ở khoảng từ 0-99
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(100));
        }
        System.out.println(integerList);
        //Tạo list số nguyên mới để lưu những số nguyên không chia hết cho 2
        List<Integer> oddList = new ArrayList<>();
        //Duyệt list ban đầu và gán những số thỏa mãn điều kiện vào list mới
        for (Integer number : integerList) {
            if (number % 2 != 0) {
                oddList.add(number);
            }
        }
        //In danh sách các số nguyên không chia hết cho 2
        System.out.println(oddList);
    }
}
