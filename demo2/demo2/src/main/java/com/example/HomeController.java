package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/Hello")
public class HomeController {

    @Inject
    private Service service;

    @Get("/")
    public String Home(){
        return "welcome back";
    }

    @Get("/sayHi")
    public  String SayHi(){
        return "Hi welcome back";
    }

    @Get("/students")
    public HttpResponse<?> getAllStudent(){
        System.out.println("get All Studnet");
        return HttpResponse.status(HttpStatus.OK).body(service.getAllStudent());
    }

    @Get("/student/{id}")
    public HttpResponse<?> getStudentById(@PathVariable("id") int id){
        System.out.println("get Student By Id "+id);
        return HttpResponse.status(HttpStatus.OK).body(service.getStudentById(id));
    }

    @Post("/add")
    public HttpResponse<?> addStudent(@Body Student student){
        System.out.println("add student "+student);
        if(service.addStudent(student))
            return HttpResponse.status(HttpStatus.OK).body("Data Added Successfully");
        else
            return HttpResponse.status(HttpStatus.OK).body("Already exist");
    }

    @Delete("/delete/{id}")
    public HttpResponse<?> deleteById(@PathVariable("id") int id){
        System.out.println("delete By Id "+id);
        if(service.deleteById(id)){
            return HttpResponse.status(HttpStatus.OK).body("data delete successfully");
        }
        else {
            return HttpResponse.status(HttpStatus.OK).body("Data does not exist");
        }
    }

    @Put("/update/{id}")
    public HttpResponse<?> updateById(@PathVariable("id") int id ,@Body Student student ){
        System.out.println("update By id "+id);
        System.out.println(student);
        return HttpResponse.status(HttpStatus.OK).body(service.updateById(id,student));
    }
}
