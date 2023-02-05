package com.example.demo;

public class Author {
    private String AuthorName;
    private int writtenPages;

    public Author(String authorName, int writtenPages) {
        AuthorName = authorName;
        this.writtenPages += writtenPages;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public int getWrittenPages() {
        return writtenPages;
    }

    public void setWrittenPages(int writtenPages) {
        this.writtenPages = writtenPages;
    }
}
