package BaiTapX.service;



import BaiTapX.model.Book;
import BaiTapX.run.ColorCode;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BookService {
    static Book[] books = new Book[0];
    Scanner scanner = new Scanner(System.in);

    public Book inputData() {
        String title, author, description, year;

        // Create element
        Book book = new Book();

        while (true) {
            if (books.length > 0) {
                System.out.println("Danh sách các tiêu đề sách hiện có:");
                for (Book b : books) System.out.println(b.getTitle());
            }


            System.out.println("Nhập tiêu đề sách: ");
            title = scanner.nextLine().trim();
            boolean isCheck = false;
            for (Book b : books) {
                if (title.equals(b.getTitle())) {
                    isCheck = true;
                    break;
                }
            }
            if (isCheck) System.err.println("Tiêu đề đã tồn tại, mời nhập lại");
            else {
                if (Pattern.matches("^.{6,50}$", title)) {
                    book.setTitle(title);
                    break;
                } else System.err.println("Tiêu đề sách (từ 6-50 kí tự)");
            }
        }

        while (true) {
            System.out.println("Nhập tên tác giả: ");
            author = scanner.nextLine().trim();
            if (Pattern.matches("^.+$", author)) {
                book.setAuthor(author);
                break;
            } else System.err.println("Tên tác giả (không bỏ trống)");
        }

        while (true) {
            System.out.println("Nhập năm xuất bản: ");
            year = scanner.nextLine().trim();
            if (Pattern.matches("^(19[7-9][0-9]|20[0-2][0-9])$", year)) {
                book.setYear(Integer.parseInt(year));
                break;
            } else System.err.println("Năm xuất bản (tối thiểu từ năm 1970 và không lớn hơn năm hiện tại)");
        }

        while (true) {
            System.out.println("Nhập mô tả sách: ");
            description = scanner.nextLine().trim();
            if (Pattern.matches("^.+$", description)) {
                book.setDescription(description);
                break;
            } else System.err.println("Mô tả sách (không bỏ trống)");
        }

        // Mã thể loại sách
        if (CategoryService.categories.length == 0) {
            System.err.println("Chưa có thể loại sách, mời thêm mới thể loại sách");
            // Quay lại menu thể loại sách
            CategoryService categoryService = new CategoryService();
            categoryService.menuCategory();
        }

        System.out.println("Danh sách thể loại sách hiện có:");
        for (int i = 0; i < CategoryService.categories.length; i++)
            System.out.printf("| STT : %d  -  Name : %s |\n", i, CategoryService.categories[i].getName());

        // yêu cầu nhập lựa chọn
        // Nếu chưa có thể loại sách thì thêm mới kèm thêm thể loại sách mới
        while (true) {
            try {
                System.out.println("Nhập mã thể loại sách: ");
                int category = Integer.parseInt(scanner.nextLine());
                if (category >= 0 && category < CategoryService.categories.length) {
                    book.setCategory(CategoryService.categories[category]);
                    break;
                } else System.err.println("Nhập lại mã thể loại sách");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số nguyên.");
            }
        }
        return book;
    }

    // 1. Thêm mới sách:
    public void addCatergory() {
        Book[] newBooks = new Book[books.length + 1];

        System.out.println("Thêm mới sách:");
        Book book = inputData();
        System.arraycopy(books, 0, newBooks, 0, books.length);
        newBooks[newBooks.length - 1] = book;
        System.out.println("Thêm sách thành công.");
        books = newBooks;
    }

    // 2. Cập nhật thông tin sách:
    public void updateBook() {
        for (Book book : books) System.out.println(book.getId() + " " + book.getTitle());
        System.out.println("Nhập id sách cần cập nhật");
        String idUpdate = scanner.nextLine();
        boolean isFound = false;
        int indexUpdate = 0;

        for (int i = 0; i < books.length; i++) {
            if (books[i].getId().equals(idUpdate)) {
                indexUpdate = i; // trả về vị trí cần cập nhật
                isFound = true;
                break;
            }
        }

        if (!isFound) System.out.println("Không có id cần cập nhật");
        else {
            Book book = inputData();
            books[indexUpdate] = book;
        }
    }

    // 3. Xóa sách:
    public void deleteBook() {
        if (books.length == 0) {
            System.out.println("Không có sách để xóa.");
            return;
        }

        System.out.println("Các cuốn sách hiện có:");
        for (Book book : books) {
            System.out.println(book.getId() + " " + book.getTitle());
        }

        System.out.println("Nhập id sách cần xóa:");
        String idDelete = scanner.nextLine().trim();

        boolean isFound = false;
        int indexDelete = 0;

        // Tìm vị trí sách cần xóa
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId().equals(idDelete)) {
                indexDelete = i; // Lưu vị trí cần xóa
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("Không có sách có id cần xóa.");
        } else {
            // Tạo mảng mới nhỏ hơn một phần tử so với books
            Book[] newBooks = new Book[books.length - 1];

            // Sao chép các phần tử từ books sang newBooks, trừ phần tử indexDelete
            System.arraycopy(books, 0, newBooks, 0, indexDelete);
            if (newBooks.length - indexDelete >= 0) {
                System.arraycopy(books, indexDelete + 1, newBooks, indexDelete, newBooks.length - indexDelete);
            }

            // Gán lại mảng books bằng newBooks
            books = newBooks;

            System.out.println("Xóa sách thành công.");
        }
    }

    // 4. Tìm kiếm sách theo  tiêu đề hoặc tên tác giả
    public void searchBook() {
        System.out.println("Nhập sách cần tìm kiếm");
        String name = scanner.nextLine().trim().toLowerCase();
        if (books.length == 0) {
            System.out.println("Không có sách nào");
            return;
        }
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(name) || book.getTitle().toLowerCase().contains(name))
                System.out.println(book);
        }
    }

    // 5. Hiển thị danh sách theo nhóm thể loại: Hiển thị sách theo từng nhóm như sau :
    public void showBookByCategory() {
        for (int i = 0; i < CategoryService.categories.length; i++) {
            System.out.println("Thể loại " + (i + 1));
            for (Book book : books) {
                if (book.getCategory().equals(CategoryService.categories[i])) System.out.println(book);
            }
        }
    }

    // 6. Menu quản lý sách
    public void menuBook() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println(ColorCode.ANSI_BLUE + "╔════════════════════════════════════════════════════════╗" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_CYAN + "║                   Menu quản lý sách                    ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_BLUE + "╠════════════════════════════════════════════════════════╣" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 1. Thêm mới sách                                       ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 2. Cập nhật thông tin sách                             ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 3. Xóa sách                                            ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 4. Tìm kiếm sách theo tiêu đề hoặc tên tác giả         ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 5. Hiển thị danh sách theo nhóm thể loại               ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_RED + "║ 6. Thoát                                               ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_BLUE + "╚════════════════════════════════════════════════════════╝" + ColorCode.ANSI_RESET);
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addCatergory();
                case 2 -> updateBook();
                case 3 -> deleteBook();
                case 4 -> searchBook();
                case 5 -> showBookByCategory();
                case 6 -> {
                    System.out.println("Tạm biệt!");
                    isExit = true;
                }
                default -> System.out.println("Lựa chọn sai, mời nhập lại!");
            }
        }
    }
}