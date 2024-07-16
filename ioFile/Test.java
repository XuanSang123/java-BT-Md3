package BaiTapXVIII.ioFile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        //Lớp File trong Java
        //đại diện cho 1 file trong bộ nhớ (cỏ thể tồn tại or k-có trong java n k có tỏng máy)
        //cung cấp tính năng làm việc vs File (ngoại trừ đọc ghi)
        //các phg thức làm việc 9h

        File file= new File("C:\\Users\\TRAN\\INTELLIJ\\Intel-MD3\\Bt_MD3\\src\\data.txt");//tạo đối tg file thong qua đường dẫn
        //check file có tồn tại k
        System.out.println("exist or not: " + file.exists());
        System.out.println("Co phai 1 thu muc k: " + file.isDirectory());

        File parent= file.getParentFile();
        System.out.println("parent is " + parent);
        System.out.println("lenght of file is " + file.length());

        try {
            boolean created= file.createNewFile();
            if(created){
                System.out.println("created successfully");
            }else{
                System.out.println("file already exists");
            }
        }catch (IOException e){
            System.out.println("Error while creating file");
        }
    }
}