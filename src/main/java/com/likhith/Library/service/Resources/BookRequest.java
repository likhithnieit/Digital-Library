package com.likhith.Library.service.Resources;

import com.likhith.Library.domain.Book;
import com.likhith.Library.domain.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter

public class BookRequest {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be black")
    private String author;
    private Genre genre;
    @Min(value = 0,message = "Cost cannot be negative")
    private Double cost;
    @Min(value = 1000, message = "Year cannot be less than 1000")
    private Integer year;

    public Book getBook(){
        Book book = new Book();
        return Book.builder().title(this.title).author(this.author).genre(this.genre)
                .cost(this.cost).year(this.year).build();
    }
}
