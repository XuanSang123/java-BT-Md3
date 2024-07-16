package BaiTapXII.Bai3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String palindrome = "Sang Heo";
        // Loại bỏ khoảng trắng và chuyển đổi sang chữ cái thường (hoặc chữ cái in hoa)
        String refinedPalindrome = palindrome.replaceAll("\\s+", "").toLowerCase();
        // Chuẩn bị Queue và Stack
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        // Thêm từng ký tự vào Queue và Stack
        for (char c : refinedPalindrome.toCharArray()) {
            queue.offer(c);
            stack.push(c);
        }
        // So sánh và in ra từng cặp ký tự từ Queue và Stack
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) {
                isPalindrome=false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("is palindrome");
        }else {
            System.out.println("is not palindrome");
        }
    }
}
