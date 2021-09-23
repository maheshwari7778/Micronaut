package com.example;

import io.micronaut.context.annotation.Bean;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class Service {

    @Inject
    public MyDao repo;

    public List<Student> getAllStudent() {
        return repo.getAllStudent();
    }

    public Student getStudentById(int id) {

        return repo.getStudentById(id);
    }

    public boolean addStudent(Student student){
        return repo.addStudent(student);
    }

    public boolean deleteById(int id){
        return repo.deleteById(id);
    }

    public Student updateById(int id,Student student){
        if(repo.updateById(id,student)){
            return student;
        }else{
            return new Student();
        }
    }
}
