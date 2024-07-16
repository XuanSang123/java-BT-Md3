package BaiTapXVIII.ioFile.model;

import BaiTapXVIII.ioFile.util.Formatter;
import BaiTapXVIII.ioFile.util.InputMethods;
import BaiTapXVIII.ioFile.util.Validate;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private int studentId;
    private String studentName;
    private Date birthday;
    private boolean sex;

    public Student() {
    }

    public Student(int studentId, String studentName, Date birthday, boolean sex) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.sex = sex;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student[" +
                "studentId : " + studentId +
                ", studentName : '" + studentName + '\'' +
                ", birthday : " + Formatter.formatDate(birthday) +
                ", sex : " + (sex ? "Nam" : "Nữ") +
                ']';
    }

    public void inputData() {
        System.out.println("Nhập tên học sinh");
        this.studentName = Validate.getStudentNameValidate();
        System.out.println("Nhập ngày sinh");
        this.birthday = InputMethods.getDate();
        System.out.println("Nhập giới tính (true/false)");
        this.sex = InputMethods.getBoolean();
    }
}