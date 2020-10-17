package pl.coderslab.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Book {

     private Long id;
     private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;

    public Book(){}

}
