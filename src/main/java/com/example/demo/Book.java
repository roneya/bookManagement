package com.example.demo;

public class Book {
    private String tittle;
    private String AuthorName;
    private int pages;


    public Book(String tittle, String authorName, int pages) {
        this.tittle = tittle;
        AuthorName = authorName;
        this.pages = pages;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
