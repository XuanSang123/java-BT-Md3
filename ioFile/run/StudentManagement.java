package BaiTapXVIII.ioFile.run;

import BaiTapXVIII.ioFile.model.Student;
import BaiTapXVIII.ioFile.service.IStudentService;
import BaiTapXVIII.ioFile.service.StudentServiceImpl;
import BaiTapXVIII.ioFile.util.InputMethods;

import java.util.List;

public class StudentManagement {
    private static IStudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=======================MENU======================");
            System.out.println("1. Hiển thị danh sách sinh viên ");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin");
            System.out.println("4. Xóa theo id");
            System.out.println("5. tim kiem theo ten");
            System.out.println("6. Hiển thị theo tên tăng dần");
            System.out.println("0. thoát");
            System.out.println("-------------------------------------------------");
            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    displayAllStudent();
                    break;
                case 2:
                    addNewStudent();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    findByName();
                    break;
                case 6:
                    displayAllStudentSortByName();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.err.println("Nhập không hợp lệ");
            }
        }
    }

    protected static void displayAllStudent() {
        if (studentService.findAll().isEmpty()) {
            System.err.println("Danh sách rỗng");
            return;
        }
        System.out.println("Danh sách sinh viên :");
        for (Student s : studentService.findAll()) {
            System.out.println(s);
        }
    }

    protected static void displayAllStudentSortByName() {
        List<Student> students = studentService.findAll();
        students.sort((o1, o2) -> o1.getStudentName().compareTo(o2.getStudentName()));
        if (students.isEmpty()) {
            System.err.println("Danh sách rỗng");
            return;
        }
        System.out.println("Danh sách sinh viên :");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    protected static void findByName() {
        System.out.println("Nhập chuỗi cần tìm");
        String name = InputMethods.getString();
        if (studentService.findByName(name).isEmpty()) {
            System.err.println("Không tim thay ket qua phù hợp");
            return;
        }
        System.out.println("Danh sách sinh viên :");
        for (Student s : studentService.findByName(name)) {
            System.out.println(s);
        }
    }

    protected static void addNewStudent() {
        System.out.println("Nhập số lượng cần thêm");
        int count = InputMethods.getInteger();
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập thông tin cho Học sinh thứ " + count);
            Student newStudent = new Student();
            newStudent.inputData();
            studentService.save(newStudent);
        }
        System.out.println("Thêm mới thành công " + count + " sinh viên");
    }

    protected static void update() {
        System.out.println("Nhap id can cap nhat: ");
        int id = InputMethods.getInteger();

        Student updateStudent = studentService.findById(id);
        if (studentService.findById(id) == null) {
            System.out.println("k ton tai id can cap nhat");
        } else {
            updateStudent.inputData(); // Assuming this method allows inputting new data for the student
            studentService.save(updateStudent);
            System.out.println("Cap nhat thanh cong");
        }
    }

    protected static void delete() {
        System.out.println("Nhap id can xoa: ");
        int id = InputMethods.getInteger();
        if (studentService.findById(id) == null) {
            System.out.println("id k ton tai");
        } else {
            studentService.deleteById(id);
            System.out.println("xoa thanh cong id " + id);
        }
    }

}