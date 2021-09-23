package example.micronaut.validators;

import example.micronaut.dao.BookRepo;
import example.micronaut.service.BookService;

public class BeanValidator {

    public static void bookServicebean(BookService bean){
        if(bean==null) {
            throw new NullPointerException("BookService bean not created yet");
        }
    }
    public static void bookRepobean(BookRepo bean){
        if(bean==null) {
            throw new NullPointerException("BookRepo bean not created yet");
        }
    }
}
