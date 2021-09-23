package example.micronaut.service;


import example.micronaut.dao.BookRepo;
import example.micronaut.entity.Book;
import example.micronaut.validators.BeanValidator;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;

import java.util.List;

@Singleton
public class BookService {
    @Inject
    public BookRepo bookRepo;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public List<Book>  getBookbyTitle(String title){
        try{
            BeanValidator.bookRepobean(bookRepo);
            logger.info("get book by title "+title);
            return bookRepo.findByTitle(title);
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
    public List<Book>  getBookbyISBN(String isbn){
        try{
            BeanValidator.bookRepobean(bookRepo);
            logger.info("get Book by ISBN "+isbn);
           return bookRepo.findByIsbn(isbn);
        }
        catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
    public List<Book>  getBookbyauthor(String author){
        try {
            BeanValidator.bookRepobean(bookRepo);
            logger.info("get Book by author "+author);
            return bookRepo.findByAuthor(author);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public List<Book>  getBookbyCategory(String category){
        try {
            BeanValidator.bookRepobean(bookRepo);
            logger.info("get Book by category "+category);
            return bookRepo.findByCategory(category);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public List<Book>  getBookbyPrice(double price){
        try {
            BeanValidator.bookRepobean(bookRepo);
            logger.info("get book by Price "+price);
            return bookRepo.findByPrice(price);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public List<Book>  getBookbydate(LocalDateTime date){
        try {
            BeanValidator.bookRepobean(bookRepo);
            logger.info("get book by Date"+date);
            return bookRepo.findByDate(date);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public boolean addone(Book book) {
        try {
            BeanValidator.bookRepobean(bookRepo);
            bookRepo.save(book);
          logger.info("Book one is added into database");
        } catch(Exception e){
           logger.error(e.getMessage());
        }

        return true;
    }

    public boolean addmultiple(List<Book>list){
        try{
            BeanValidator.bookRepobean(bookRepo);
            bookRepo.saveAll(list);
            logger.info("Multiple book added into Repo");
        }
        catch(Exception e){
            logger.error(e.getMessage());
        }

        return true;
    }
    public boolean deleteBookbyId(String isbn){
        try{
            BeanValidator.bookRepobean(bookRepo);
            bookRepo.deleteById(isbn);
            logger.info("Book Successfully deleted from database");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return true;
    }
    public boolean updateBookbyId(String isbn,Book book){
        try {
            //bookRepo.updateBookbyId(isbn,book);
            BeanValidator.bookRepobean(bookRepo);
            bookRepo.update(book);
            logger.info("update book by id");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return true;
    }

    public List<Book> getallbooks() {
        try{
            BeanValidator.bookRepobean(bookRepo);
            logger.info("get all books from database");
            return (List<Book>) bookRepo.findAll();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
}
