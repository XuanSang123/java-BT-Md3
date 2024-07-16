package BaiTapXII.Bai4;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String brackets="((2*3)+5*(2*1))";
        Stack<String> stack=new Stack<>();
        for (int i=0;i<brackets.length();i++){
            if (brackets.charAt(i)=='('){
                stack.push("(");
            }
        }
        for (int i=0;i<brackets.length();i++){
            if (brackets.charAt(i)==')'&&!stack.isEmpty()){
                stack.pop();
            }

        }
        if (stack.isEmpty()){
            System.out.println("bieu thuc dung");
        }
        else{
            System.out.println("bieu thuc sai");
        }
    }
}