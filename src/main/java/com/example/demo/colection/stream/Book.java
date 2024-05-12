package com.example.demo.colection.stream;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private String title;
    private List<Author> authors;
}
