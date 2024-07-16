package BaiTapXIII.Bai4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> hashMap1 = new HashMap<>();
        hashMap1.put(1, "hello");
        hashMap1.put(3, "no thank you");
        hashMap1.put(2, "yes");
        System.out.println(hashMap1);
        //thay vì xài putAll thì chèn trực tiếp hashMap1 vào trong hashMap2 thì sẽ nhanh hơn
        Map<Integer, String> hashMap2 = new HashMap<>(hashMap1);
        System.out.println(hashMap2);
        int isCheckHashMap = 4;
        if (hashMap2.containsKey(isCheckHashMap)){
            System.out.println("true");
        }else {
            System.out.println("false");
    }
}}
