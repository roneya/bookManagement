package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class LibraryController {
    private HashMap<String,Book> bookMap; //book name and its object;

    private HashMap<String,Author> authorMap; //author name and its object
    private HashMap<String,List<Book>> authorBooks; //name of author and his book list

    public LibraryController() {
        this.bookMap = new HashMap<>();
        this.authorMap = new HashMap<>();
        this.authorBooks = new HashMap<>();
    }
    @PostMapping("/add_book")
    public String addBook(@RequestBody Book book)
    {
        if(bookMap.containsKey(book.getTittle()))
            return "Book already in db";
        bookMap.put(book.getTittle(),book);
        if(!authorMap.containsKey(book.getAuthorName()))
        {
            Author author = new Author(book.getAuthorName(),book.getPages());
            authorMap.put(author.getAuthorName(),author);
        }

        if(!authorBooks.containsKey(book.getAuthorName()))
        {
            List<Book> l = new ArrayList<>();
            l.add(book);
            authorBooks.put(book.getAuthorName(),l);
        }
        else {
            List<Book> l = authorBooks.get(book.getAuthorName());
            l.add(book);
            authorBooks.put(book.getAuthorName(),l);
        }
        return "book has been added";
    }
    @PostMapping("/add_author")
    public String addAuthor(@RequestBody Author author)
    {
        if(authorMap.containsKey(author.getAuthorName()))
            return "Author already in db";
        else
        {
            authorMap.put(author.getAuthorName(),author);
        }
        return "Author has been added";
    }
    @GetMapping("get_book")
    public String getBook(){
        int max=0;
        String str="";
        for(String s:bookMap.keySet())
        {
            if(bookMap.get(s).getPages()>max)
            {
                max = bookMap.get(s).getPages();
                str = s;
            }
        }
        return str;
    }

    @GetMapping("get_author")
    public String getAuthor()
    {
        int max =0;
        String str="";
        for(String s: authorMap.keySet())
        {
            if(authorMap.get(s).getWrittenPages()>max)
            {
                max = authorMap.get(s).getWrittenPages();
                str= s;
            }
        }
        return str;
    }


    @PutMapping("/putBookPages")
    public Book putBookPages(@RequestParam String name, @RequestBody int pages)
        {
            if(bookMap.containsKey(name))
            {
                Book book = bookMap.get(name);
                book.setPages(pages);
                return book;
            }
            else return null;

    }

}
