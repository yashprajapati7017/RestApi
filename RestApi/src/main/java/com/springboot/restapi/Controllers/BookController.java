package com.springboot.restapi.Controllers;

import com.springboot.restapi.BookService.BookContaner;
import com.springboot.restapi.Entityes.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookContaner bookContaner;

    @GetMapping("/book")
    public List<Book> Book(){
        return bookContaner.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id){
        return bookContaner.getBookById(id);
    }

    @PostMapping("/book")
    public Book postBook(@RequestBody Book book){
        Book book1 = bookContaner.postBook(book);
        return book1;
    }

    @DeleteMapping("/book/{id}")
    public void Delete(@PathVariable("id") int id){
        bookContaner.deleteBookById(id);
    }

    @PutMapping("/book/{id}")
    public void Update(@RequestBody Book book, @PathVariable("id") int id){
        bookContaner.updateBook(id, book);

    }

}
