package example.micronaut.dao;

import example.micronaut.entity.Book;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public abstract class BookRepo implements CrudRepository<Book,String> {

    public abstract List<Book> findByTitle(String title);
    public abstract List<Book> findByIsbn(String isbn);
    public abstract List<Book> findByAuthor(String author);
    public abstract List<Book> findByCategory(String category);
    public abstract List<Book> findByPrice(double price);
    public abstract List<Book> findByDate(LocalDateTime date);

}
