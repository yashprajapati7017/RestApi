package com.springboot.restapi.BookService;

import com.springboot.restapi.Entityes.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookContaner {

   static List<Book> list = new ArrayList<>();

   static {

       list.add(new Book(101,"java","xyz","learn java"));
       list.add(new Book(102,"phyton","abc","learn phyton"));
       list.add(new Book(103,"c","mno","learn c"));
       list.add(new Book(104,"c++","mno","learn c++"));
       list.add(new Book(105,"sql","stu","learn sql"));
   }

   public List<Book> getAllBooks(){
       return list;
   }

   public Book getBookById(int id){
       Book book = null;
       book=list.stream().filter(e -> e.getId() == id).findFirst().get();
       return book;
   }

   public Book postBook(Book book){
       list.add(book);
       return book;
   }

   public void deleteBookById(int id){
       list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
   }

   public void updateBook(int id,Book book){
       list.stream().map(e->{
               if(e.getId()==id){
                   e.setName(book.getName());
                   e.setAuthor(book.getAuthor());
                   e.setTitle(book.getTitle());
                   return e;
       }
               else{
                   return null;
               }
       }).collect(Collectors.toList());
   }

}
