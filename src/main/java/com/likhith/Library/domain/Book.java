package com.likhith.Library.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter //Lombok will automatically generate getters for this class
@Setter //Lombok will automatically generate setters for this class
@AllArgsConstructor //Lombok will automatically generate all argument constructor
@NoArgsConstructor //Lombok will automatically generate no argument constructor
@Entity // To mark this class to map to the database
@Builder // Feature of Lombok used to create the object of this class in an easy pattern
@Table(name = "books") // TO specify the table to be created in the database
public class Book {
    @Id // Represents the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id; //not part of request
    private String title;
    private String author;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private Double rating; //not part of request
    private Double cost;
   // private List<Review> reviewList; //not part of request
    private Integer year;

}
