package example.micronaut.controller;

import example.micronaut.entity.Book;
import example.micronaut.service.BookService;

import example.micronaut.validators.BeanValidator;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

@Controller("/")
public class HomeController {

     @Inject
    public BookService bookService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Get("/sayHi")
    public String SayHi(){
        logger.info("Say Hi Welcome back");
        return "Hi welcome back";
    }

    @Get("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> getallbooks(){
        logger.info("get all books from database");
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.getallbooks());
        }catch(Exception e){
            logger.error(e.getMessage());
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");

        }

    }

    @Get("/getbytitle/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> getBookbyTitle(@NonNull  @PathVariable("title") String title){
        logger.info("get book by title-- "+title);
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.getBookbyTitle(title));
        }catch(Exception e){
            logger.error(e.getMessage());
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }

    @Get("/getbyisbn/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> getBookbyISBN(@NonNull @PathVariable("isbn") String isbn){
        logger.info("get book by isbn "+isbn);
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.getBookbyISBN(isbn));
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }

    @Get("/getbyauthor/{author}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> getBookbyauthor(@PathVariable("author") String author){
        logger.info("get book by author "+author);
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.getBookbyauthor(author));
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }

    @Get("/getbycategory/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> getBookbyCategory(@PathVariable("category") String category) {
        logger.info("Controller-------get book by category " + category);
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.getBookbyCategory(category));
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }

    @Get("/getbyprice/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> getBookbyPrice(@PathVariable("price") double price) {
        logger.info("Controller-------get book by Price "+price);
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.getBookbyPrice(price));
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }

    @Get("/getbydate/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> getBookbydate(@PathVariable("date") LocalDateTime date){
        logger.info("Controller------get book by date " +date);
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.getBookbydate(date));
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }

    @Post("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> addone(@Body Book book){
        logger.info("Controller-----addone book to data base "+book);
        book.setDate(LocalDateTime.now());
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.addone(book));
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }

    @Post("/adds")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> addmultiple(@Body List<Book> book){
        logger.info("Controller---------add multiple book "+book);
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.addmultiple(book));
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }

    @Delete("/delete/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> deleteBookbyId(@PathVariable("isbn") String isbn){
        logger.info("Controller-----------delete book by id "+isbn);
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.deleteBookbyId(isbn));
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }

    @Put("/update/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> updateBookbyId(@PathVariable("isbn") String isbn ,@Body Book book){
        logger.info("Controller------------update book by id "+isbn);
        try {
            BeanValidator.bookServicebean(bookService);
            return HttpResponse.status(HttpStatus.OK).body(bookService.updateBookbyId(isbn, book));
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("Something gone wrong");
        }
    }



}
