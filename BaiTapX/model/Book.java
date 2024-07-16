package BaiTapX.model;

import java.util.Scanner;

public class Book {
    private String id, title, author,description;
    private Category category;
    private int year;
    public static int count=1;
    public Book(){
        int a = count++;
        this.id=String.format("B%03d", a);
    }
    public Book(String id, String title, String author, String description, Category category, int year) {
        int a = count++;
        this.id = String.format("B%03d", a);
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", year=" + year +
                '}';
    }
}
