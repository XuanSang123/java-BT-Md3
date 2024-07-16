package BaiTapXII.Bai6;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        for (int i=0;i<5;i++){
            int num = sc.nextInt();
            stack.push(num);
        }
        // Tìm phần tử nhỏ nhất bằng cách duyệt qua Stack
        int min = stack.peek();
        while (!stack.empty()){
            int num = stack.pop();
            if (min>num){
                min=num;
            }
        }
        System.out.println("Min number is: "+min);
    }
}
