package pl.coderslab.controller;


import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;
import pl.coderslab.model.Message;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    MemoryBookService memoryBookService;

    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }


    @GetMapping
    public List<Book> getAllBook() {
        return memoryBookService.getAllBooks();
    }


    @GetMapping("{id}")
    public Book getBookById(@PathVariable Long id) {
        return memoryBookService.getBookById(id);
    }

    @PostMapping("")
    public String addBook(@RequestBody Book book) {
        return memoryBookService.addBook(book);
    }

    @PutMapping("")
    public String updateBook(@RequestBody Book book) {
        return memoryBookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public Message deleteBook(@PathVariable Long id) {
        return memoryBookService.deleteBook(id);
    }
}
