package example.micronaut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Book {


    @Id
    @Column(length = 10)
    private String isbn;

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @Column(nullable = false)
    private String author;

    @NonNull
    @Column(nullable = false)
    private String category;

    @NonNull
    private double price;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime date;

}
