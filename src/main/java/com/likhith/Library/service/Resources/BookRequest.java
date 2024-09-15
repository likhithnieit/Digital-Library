package com.likhith.Library.service.Resources;

import com.likhith.Library.domain.Book;
import com.likhith.Library.domain.Genre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    private String title;
    private String author;
    private Genre genre;
    private Double cost;
    private Integer year;

    public Book getBook(){
        return Book.builder().title(this.title).author(this.author).genre(this.genre)
                .cost(this.cost).year(this.year).build();
    }
}
