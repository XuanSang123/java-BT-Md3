package BaiTapXI.Bai1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,6,2,4,8,3,9,7));
        Integer maxInteger = Collections.max(list1);
        System.out.println("so lon nhat"+maxInteger);
        System.out.println("number before reverse:"+list1);
        Collections.reverse(list1);
        System.out.println("number after reverse:"+list1);
        System.out.println("before sorted:"+list1);
        //tang dan
        Collections.sort(list1);
        System.out.println("after sorted:"+list1);
        //giam dan
        list1.sort(Collections.reverseOrder());
        System.out.println(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(13);
        list2.add(12);
        list2.add(17);
        list2.add(14);
        list1.addAll(list2);
        System.out.println(list1);


    }
}
