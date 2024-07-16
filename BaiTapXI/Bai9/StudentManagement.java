package BaiTapXI.Bai9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class StudentManagement {
    public static List<Student> students = new ArrayList<>();
    //show all
    public void showAllStudent(){
        if (!students.isEmpty()){
            for (Student student : students){
                System.out.println(student);
            }
        }
    }
    //add student:
    public void addStudent(Student student){
        students.add(student);
    }
    //delete student
    public void removeStudent(int studentId){
        int index =-1;
        for (int i=0;i< students.size();i++){
            if (students.get(i).getStudentId()==studentId){
                index=i;
                break;
            }
        }
        if (index==-1) System.err.println("khong tim thay ID!");
        else students.remove(index);
    }
    // find student by Name
    public void searchStudentByName(Scanner scanner){
        System.out.println("nhap ten hoc sinh can tim:");
        String name = scanner.nextLine().toLowerCase().trim();
        for (Student student : students){
            if (student.getName().toLowerCase().contains(name)) System.out.println(student);
        }
    }
    // find student by ID
    public Student findStudentById(int studentId){
        boolean isCheck = false;
        Student studentFind = null;
        for (Student student:students){
            if (student.getStudentId()==studentId){
                studentFind=student;
                isCheck=true;
                break;
            }
        }
        if (!isCheck){
            System.err.println("Khong tim thay hoc sinh nao!");
            return null;
        }
        return studentFind;
    }
    //getAverageScore:
    public double getAverageScore(){
        double sum =0;
        for (Student student : students){
            sum += student.getAverageScore();
        }
        return sum;
    }
    //sort student by name
public void sortByName(){
        Comparator.comparing(Student::getAverageScore);
}
}
