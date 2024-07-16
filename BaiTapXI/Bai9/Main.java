package BaiTapXI.Bai9;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement =new StudentManagement();
        studentManagement.addStudent(new Student(1,"Hien",8.4));
        studentManagement.showAllStudent();
    }
}
