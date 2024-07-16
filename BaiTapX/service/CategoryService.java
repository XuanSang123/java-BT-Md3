package BaiTapX.service;



import BaiTapX.model.Category;
import BaiTapX.run.ColorCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CategoryService {
    static Category[] categories = new Category[0];
    Scanner scanner = new Scanner(System.in);


    public Category inputData() {

        String name, status;

        Category category = new Category();

        while (true) {
            if (categories.length > 0) {
                System.out.println("Danh sách các tên thể loại sách hiện có:");
                for (Category c : categories) System.out.println(c.getName());
            }

            System.out.println("Nhập tên thể loại sách: ");
            name = scanner.nextLine().trim();
            boolean isCheck = false;

            for (Category c : categories) {
                if (name.equals(c.getName())) {
                    isCheck = true;
                    break;
                }
            }
            if (isCheck) System.err.println("Tên thể loại đã tồn tại");
            else {
                if (Pattern.matches("^.{6,30}$", name)) {
                    category.setName(name);
                    break;
                } else System.err.println("Tên thể loại từ 6-30 kí tự");
            }
        }

        while (true) {
            System.out.println("Nhập trạng thái thể loại sách: ");
            status = scanner.nextLine().trim();
            if (Pattern.matches("(?i)true|false", status)) {
                category.setStatus(Boolean.parseBoolean(status));
                break;
            } else System.err.println("Trạng thái thể loại (chỉ nhận true/false)");
        }

        return category;
    }


    // 1. Add categories
    public void addCatergory() {
        Category[] newCategories = new Category[categories.length + 1];

        System.out.println("Thêm mới thể loại sách:");
        Category category = inputData();

        // Copy old categories to new array
        System.arraycopy(categories, 0, newCategories, 0, categories.length);

        // Add new category to the end
        newCategories[newCategories.length - 1] = category;

        // Update categories reference
        categories = newCategories;
    }

    // 2. Display categories and sort by Name
    public void displayCategories() {
        Arrays.sort(categories, Comparator.comparing(Category::getName));
        if (categories.length == 0) {
            System.out.println("Không có thể loại sách nào");
            return;
        }
        for (Category category : categories) {
            System.out.println(category.getId() + " " + category.getName() + " " + category.isStatus());
        }
    }

    // 3. Thống kê thể loại và số sách có trong mỗi thể loại
    public void countBookInCategory() {
        for (Category category : categories) {
            int count = 0;
            for (int i = 0; i < BookService.books.length; i++) {
                if (BookService.books[i].getCategory().getName().equals(category.getName())) {
                    count++;
                }
            }
            System.out.println(category.getName() + ": " + count);
        }
    }

    // 4. Update thể loại:
    public void updateCategory() {
        for (Category category : categories) System.out.println(category.getId() + " " + category.getName());
        System.out.println("Nhập id sách cần cập nhật");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        int indexUpdate = 0;
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getId() == idUpdate) {
                indexUpdate = i; // // trả về vị trí cần cập nhật thông tin
                isFound = true;
                break;
            }
        }
        if (isFound) categories[indexUpdate] = inputData();
        else System.err.println("Không có thể loại sách với id: " + indexUpdate + " vừa nhập");
    }

    // 5.  Xóa thể loại : trước khi xóa, cần kiểm tra trong thể loại có sách đang tham chiếu tới thể loại đó hay không? Nếu có thông báo “Thể loại đang có sách”, không thực hiện xóa thể loại.
    public void deleteCategories() {
        if (categories.length == 0) return;
        System.out.println("Các thể loại hiện có:");
        for (Category category : categories) {
            System.out.println(category.getId() + " " + category.getName());
        }

        System.out.println("Nhập id thể loại cần xóa:");
        int idDelete = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        int indexDelete = 0;

        // Find the index of the category to be deleted
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getId() == idDelete) {
                indexDelete = i;
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.err.println("Không có id cần xóa");
        } else {
            // Check if there are any books associated with the category
            for (int i = 0; i < BookService.books.length; i++) {
                if (BookService.books[i].getCategory().getId() == idDelete) {
                    System.err.println("Thể loại đang có sách");
                    return;
                }
            }

            // Proceed with deletion if no books are associated with the category
            Category[] newCategories = new Category[categories.length - 1];
            System.arraycopy(categories, 0, newCategories, 0, indexDelete);
            System.arraycopy(categories, indexDelete + 1, newCategories, indexDelete, categories.length - indexDelete - 1);

            System.out.println("Xóa thành công");
            categories = newCategories;
        }
    }

    // 6. Menu thể loại sách
    public void menuCategory() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println(ColorCode.ANSI_BLUE + "╔════════════════════════════════════════════════════════╗" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_CYAN + "║             Menu quản lý thể loại sách                 ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_BLUE + "╠════════════════════════════════════════════════════════╣" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 1. Thêm mới thể loại sách                              ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 2. Hiển thị danh sách theo tên thể loại A – Z          ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 3. Thống kê thể loại và số sách có trong mỗi thể loại  ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 4. Cập nhật thể loại                                   ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_YELLOW + "║ 5. Xóa thể loại (kiểm tra tồn tại sách trước khi xóa)  ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_RED + "║ 6. Thoát                                               ║" + ColorCode.ANSI_RESET);
            System.out.println(ColorCode.ANSI_BLUE + "╚════════════════════════════════════════════════════════╝" + ColorCode.ANSI_RESET);
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addCatergory();
                case 2 -> displayCategories();
                case 3 -> countBookInCategory();
                case 4 -> updateCategory();
                case 5 -> deleteCategories();
                case 6 -> {
                    System.out.println("Tạm biệt!");
                    isExit = true;
                }
                default -> System.out.println("Lựa chọn sai, mời nhập lại!");
            }
        }
    }
}