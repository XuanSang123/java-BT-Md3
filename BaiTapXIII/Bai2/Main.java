package BaiTapXIII.Bai2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int [] number = {1,2,3,4,5,1,2,3,4,2,1,4,3};
        //tạo hashMap để lưu trữ số lần xuất hiện của các phần tử
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : number){
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }
            else{
                map.put(num, 1);
            }
        }
        Map<Integer, Integer> uniqueElements = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue()==1){
                uniqueElements.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Các phần tử duy nhất và số lần xuất hiện:");
        for (Map.Entry<Integer,Integer>entry : uniqueElements.entrySet()){
            System.out.println("Phan Tu"+entry.getKey()+"xuat hien"+entry.getValue()+"lan");
        }
    }
}
