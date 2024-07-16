//package BaiTap.BaiTapVI;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class BT1 {
//    public static void main(String[] args) {
//        String s="rikkeiAcademy";
//        System.out.println(s.isEmpty());//rỗng ra True - không rỗng ra False
//        String s2= s.trim();
//        System.out.println(s2);
//        String s3="NGUYEN THE HIEN";
//        System.out.println(s.equals(s3));
//        //Arrays.toString   để biến chuỗi thành mảng
//        System.out.println(Arrays.toString(s.split("")));
//        //nối chuỗi
//        System.out.println(s+s3);
//        System.out.println(s.concat(s3));
//        String s4="ri";
//        System.out.println(s.contains(s4));
//        //Replace đổi tất cả ký tự k thành m
//        String s5=s.replace('k','m');
//        System.out.println(s5);
//        //
//        System.out.println("Input string: ");
//        Scanner sc=new Scanner(System.in);
//        String input=sc.nextLine();
//        StringBuilder s6=new StringBuilder(input);
//        int index = s6.indexOf("k");
//        System.out.println(index);
//        s6.replace(index, index+1,"m");
//        s6.delete(index,index+1);
//        System.out.println(s6);
//    }
//}
