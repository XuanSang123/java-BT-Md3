package BaiTapXI.Bai6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,4,5,1));
        List<Integer> list1 = new ArrayList<>();
        for (Integer integer : list) {
            if (!list1.contains(integer)) {
                list1.add(integer);
            }
        }
        System.out.println(list1);
    }
}
