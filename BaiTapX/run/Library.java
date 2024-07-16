package BaiTapX.run;



import BaiTapX.service.BookService;
import BaiTapX.service.CategoryService;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isExit = false;
        while (!isExit) {
            System.out.print("\u001B[H\u001B[2J");
            // In menu với màu chữ và khung khác nhau
            System.out.println(ColorCode.ANSI_BLUE + "╔══════════════════════════════════════╗" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_CYAN + "║          Quản lý thư viện            ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_BLUE + "╠══════════════════════════════════════╣" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 1. Quản lý Thể loại.                 ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 2. Quản lý Sách.                     ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_RED + "║ 3. Thoát.                            ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_BLUE + "╚══════════════════════════════════════╝" + ColorCode.ANSI_RESET);

            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    CategoryService categoryService = new CategoryService();
                    categoryService.menuCategory();
                }
                case 2 -> {
                    BookService bookService = new BookService();
                    bookService.menuBook();
                }
                case 3 -> {
                    System.out.println("Tạm biệt!");
                    isExit = true;
                }
                default -> System.out.println("Lựa chọn sai, mời nhập lại!");
            }
        }
    }
}