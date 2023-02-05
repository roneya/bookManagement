package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
//	Create an author and book management system which can help us easily to perform CRUD operations.
//book: name, author, pages,
//author: name, writtenpages,
//	POST :Add book(been there), add author
//		GET : the bookName with highest no. of pages.
//		PUT the (path bookname, updated pages);
//		GET author who has written the highest no. of pages