package BaiTapX.model;

import java.util.Scanner;

public class Category {
    private int id;
    private String name;
    private boolean status;
    private static int count =1;
    public Category(){}
    public Category(int id, String name, boolean status) {
        this.id = count++;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void displayData(){}
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
