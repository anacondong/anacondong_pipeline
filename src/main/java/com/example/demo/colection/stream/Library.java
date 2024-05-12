package com.example.demo.colection.stream;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public static List<Library> initLibraryData(int numberOfLibraries) {
        List<Library> libraries = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= numberOfLibraries; i++) {
            Library library = Library.builder()
                    .name("Library " + i)
                    .books(generateBooks(random.nextInt(5) + 1))
                    .build();
            libraries.add(library);
        }

        return libraries;
    }

    private static List<Book> generateBooks(int numberOfBooks) {
        List<Book> books = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= numberOfBooks; i++) {
            Book book = Book.builder()
                    .title("Book " + i)
                    .authors(generateAuthors(random.nextInt(3) + 1))
                    .build();
            books.add(book);
        }

        return books;
    }

    private static List<Author> generateAuthors(int numberOfAuthors) {
        List<Author> authors = new ArrayList<>();

        for (int i = 1; i <= numberOfAuthors; i++) {
            Author author = Author.builder()
                    .name("Author " + i)
                    .build();
            authors.add(author);
        }

        return authors;
    }
}
