package BaiTapXII.Bai1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        //tạo Stack và thêm vào số từ cần nhập
        Stack<String> Text = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a nunmber of Text:");
        int numberOfText = sc.nextInt();

        //dùng vòng lập for để nhập từ mình muốn thêm vào
        for (int i = 0; i < numberOfText; i++) {
            System.out.println("Nhap tu thu:"+(i+1));
            Text.push(sc.next());
        }
        System.out.println("Text reverse already");

        //sử dụng vòng lập while để đảo ngược lại các từ
        while (!Text.isEmpty()) {
            String temp = Text.pop();
            System.out.print(temp);
            if (!Text.isEmpty()) {
                System.out.print(",");
            }

        }

    }
}
