package org.example.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    private Long id;
    private String isbn;
    private String name;
    private String author;
    private String category;
    private int qty;

}
