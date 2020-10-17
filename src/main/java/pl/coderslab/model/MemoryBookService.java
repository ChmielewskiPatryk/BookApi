package pl.coderslab.model;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getAllBooks() {
        return list;
    }

    public Book getBookById(Long id) {

        Book book = list.stream()
                .filter(list -> id.equals(list.getId()))
                .findFirst()
                .orElse(null);
        return book;
    }

    public Book getBookByIsbn(String isbn) {
        Book book = list.stream()
                .filter(list -> isbn.equals(list.getIsbn()))
                .findFirst()
                .orElse(null);
        return book;
    }

    public String addBook(Book book) {
        if (getBookByIsbn(book.getIsbn()) == null) {
            book.setId(nextId++);
            list.add(book);
            return "Added";
        } else {
            return "Alredy exist";
        }

    }

    public String updateBook(Book book) {

        if (getBookById(book.getId()) != null) {
            return "book updated";
        } else {
            return "book not found";
        }


    }

    public Message deleteBook(Long id) {
        if (getBookById(id) != null) {
            list.remove(getBookById(id));
            return new Message("Deleted");
        }
        return new Message("Not found");
    }


}
