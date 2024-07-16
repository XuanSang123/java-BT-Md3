package BaiTapXVII.Bai2;

import BaiTapXVII.Exception.UnCheckedException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnCheckedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your First Name: ");
        int n;
        while(true){
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n<0){
                    System.err.println("nhap 1 so >=0");
                }else{
                    break;
                }
            }catch (NumberFormatException e){
                System.err.println("nhap 1 so:");
            }
        }
        int[]arrInt=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("nhap phan tu arr[i]:");
            while(true){
                try {
                    arrInt[i] = Integer.parseInt(sc.nextLine());
                }catch (NumberFormatException e){
                    System.err.println("ban phai nhap 1 so");}
            }
        }
        if (arrInt.length==0){
            throw new RuntimeException("Loi! mang khong co phan tu");
        }
    }
}
