//package BaiTapIV;
//
//import java.util.Scanner;
//
//public class Employee {
//    //attribute
//    private int employeeId,age;
//    private String employeeName,sex;
//    private double rate,salary;
//    public Employee(){}
//    public Employee(int employeeId,String employeeName,int age,String sex,int rate,int salary){
//    this.employeeId=employeeId;
//    this.employeeName=employeeName;
//    this.age=age;
//    this.sex=sex;
//    this.rate=rate;
//    this.salary=salary;
//}
//public int setEmployee(){
//    return employeeId;
//}
//public String setEmployeeName(){
//    return employeeName;
//}
//public int setAge(){
//    return age;
//}
//public String setSex(){
//    return sex;
//}
//public double setRate(){
//    return rate;
//}
//public void inputData(){
//    Scanner sc=new Scanner(System.in);
//    System.out.println("nhap ma nhan vien:");
//    int employeeId=Integer.parseInt(sc.nextLine());
//    System.out.println("nhap ten nhan vien:");
//    String employeeName=sc.nextLine();
//    System.out.println("nhap tuoi nhan vien:");
//    int age=Integer.parseInt(sc.nextLine());
//    System.out.println("nhap gioi tinh nhan vien:");
//    String sex=sc.nextLine();
//    System.out.println("nhap he so luong nhan vien:");
//    double rate=Double.parseDouble(sc.nextLine());
//}
//public void displayData(){
//    System.out.println("ma nhan vien"+this.employeeId);
//    System.out.println("ten nhan vien"+this.employeeName);
//    System.out.println("tuoi"+this.age);
//    System.out.println("gioi tinh"+this.sex);
//    System.out.println("he so luong"+this.rate);
//    System.out.println("luong"+this.salary);
//
//}
//public void calSalary(){
//   this.salary=this.rate*1300000;
//}
//}
