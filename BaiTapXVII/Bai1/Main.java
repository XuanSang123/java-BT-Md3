package BaiTapXVII.Bai1;

import BaiTapXVII.Exception.CheckedException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CheckedException {
        int num = 0, num1 = 0;
        Scanner sc = new Scanner(System.in);
        boolean ischeckNumber=true;
        while(ischeckNumber){
            try{
                System.out.println("nhap so thu 1:");
                num = Integer.parseInt(sc.nextLine());
                ischeckNumber=false;
            }catch(Exception e){
                System.err.println(e.getMessage());
            }}
        boolean ischeckNumber2=true;
        while(ischeckNumber2) {
            try {
                System.out.println("nhap so thu 2:");
                num1 = Integer.parseInt(sc.nextLine());
                ischeckNumber2=false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int sum = num + num1;
        System.out.println(sum);
    }
}
