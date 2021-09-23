package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HomeController {
    @Get("/")
    public String Home(){
        return "welcome back";
    }

    @Get("/sayHi")
    public String SayHi(){
        return "Hi welcome back";
    }
}
