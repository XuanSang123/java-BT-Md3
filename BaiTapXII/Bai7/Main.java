package BaiTapXII.Bai7;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Khởi tạo một Stack để lưu trữ các ký tự của chuỗi đầu vào.
        Stack<Character> stack = new Stack<>();
        System.out.println("Nhap chuoi:");
        String input = sc.nextLine().trim().toLowerCase();
        //Đưa các ký tự của chuỗi vào Stack bằng cách sử dụng vòng lặp for.
        for (Character c : input.toCharArray()) {
            stack.push(c);
        }
        //Khởi tạo một biến flag để lưu trữ kết quả kiểm tra, ban đầu gán giá trị là true.
        boolean isFlag = true;
        //Duyệt qua từng ký tự trong chuỗi đầu vào bằng vòng lặp while, và so sánh với ký tự đầu
        // tiên trong Stack bằng phương thức peek().
        while (!stack.isEmpty()) {
        Character firstChar = stack.pop();
            //Nếu ký tự trong chuỗi lớn hơn ký tự đầu tiên trong Stack, ta gán giá trị của
            // flag là false và thoát khỏi vòng lặp.
            for (Character c : stack) {
                if (firstChar>c){
                    isFlag = false;
                    break;
                }
            }
        }
        if (isFlag) System.out.println("giam dan!!!");
        else System.out.println("khong phai giam dan!!!");
    }
}
