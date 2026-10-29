package com.springboot.restapi.Controllers;

import com.springboot.restapi.BookService.BookContaner;
import com.springboot.restapi.Entityes.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookContaner bookContaner;

    @GetMapping("/book")
    public ResponseEntity<List<Book>> Book(){

       List<Book> list= bookContaner.getAllBooks();

       if(list.size()<=0){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        Book book= bookContaner.getBookById(id);
        if(book==null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> postBook(@RequestBody Book book){
        Book book1=null;
        try {
            book1 = bookContaner.postBook(book);
        }catch (Exception e){
            e.printStackTrace();
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(book1));
    }

    @DeleteMapping("/book/{id}")
    public void Delete(@PathVariable("id") int id){
        try {
            bookContaner.deleteBookById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PutMapping("/book/{id}")
    public void Update(@RequestBody Book book, @PathVariable("id") int id){
        try {
            bookContaner.updateBook(id, book);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
