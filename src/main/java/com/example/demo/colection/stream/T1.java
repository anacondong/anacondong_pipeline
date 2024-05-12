package com.example.demo.colection.stream;

import java.util.List;
import java.util.stream.Collectors;

public class T1 {

    public static void main(String[] args) {
        // Initialize library data
        List<Library> libraries = Library.initLibraryData(3);

        // Print each library with its books and authors
        System.out.println("Libraries:");
        libraries.stream().forEach(library -> {
            System.out.println("Library: " + library.getName());
            library.getBooks().forEach(book -> {
                System.out.println("  Book: " + book.getTitle());
                book.getAuthors().forEach(author -> {
                    System.out.println("    Author: " + author.getName());
                });
            });
        });

        // Flatten the list of books
        List<Book> allBooks = libraries.stream()
                .flatMap(library -> library.getBooks().stream())
                .collect(Collectors.toList());
        System.out.println("\nAll Books:");
        allBooks.forEach(book -> {
            System.out.println("Book: " + book.getTitle());
            book.getAuthors().forEach(author -> {
                System.out.println("  Author: " + author.getName());
            });
        });

        // Filter books written by a specific author
        String authorName = "Author 1";
        List<Book> booksByAuthor = allBooks.stream()
                .filter(book -> book.getAuthors().stream()
                        .anyMatch(author -> author.getName().equals(authorName)))
                .collect(Collectors.toList());
        System.out.println("\nBooks written by " + authorName + ":");
        booksByAuthor.forEach(book -> {
            System.out.println("Book: " + book.getTitle());
            book.getAuthors().forEach(author -> {
                System.out.println("  Author: " + author.getName());
            });
        });
    }

}
