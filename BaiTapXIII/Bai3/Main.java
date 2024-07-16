package BaiTapXIII.Bai3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(2, 5);
        hashMap.put(1,2);
        hashMap.put(5, 6);
        hashMap.put(3, 1);

        // Chuyển đổi HashMap thành một danh sách List<Map.Entry<Integer, Integer>>
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());

        // Sắp xếp danh sách list dựa trên giá trị tăng dần
        list.sort(Map.Entry.comparingByValue());
        // In danh sách đã sắp xếp
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

    }
}
