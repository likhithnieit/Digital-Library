package com.likhith.Library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String id; //not part of request
    private String title;
    private String author;
    private Genre genre;
    private Double rating; //not part of request
    private Double cost;
    private List<Review> reviewList; //not part of request
    private Integer year;

}
