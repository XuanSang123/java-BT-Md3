package BaiTapXIII.Bai5;

import java.util.*;
import java.util.stream.Stream;
//Sắp xếp phần tử có giá trị tăng dần trong TreeMap.
//Tìm phần tử nhỏ nhất trong TreeMap
//Tìm phần tử lớn thứ 2 trong TreeMap
//Sắp xếp các phần tử theo giá trị giảm dần trong TreeMap

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> randomList = Stream.generate(()->rand.nextInt(50)).limit(100).toList();
        TreeMap<Integer,Integer> tree = new TreeMap<>();
        for (Integer e : randomList) {
            tree.put(e,0);
        }
        for (Integer key : tree.keySet()) {
            System.out.println("key "+key);
        }
        System.out.println("phan tu nho nhat: "+tree.firstKey());
        System.out.println("phan tu lon thu 2: "+tree.lowerKey(tree.lastKey()));
        NavigableSet<Integer> integer = tree.descendingKeySet();
        while (!integer.isEmpty()) {
            System.out.println(integer.pollFirst());
        }
    }
}
