package com.example;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class Service {

    @Inject
    public StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        List<Student>li=new ArrayList<>();
        li= (List<Student>) studentRepository.findAll();
        return li;
    }

    public Student getStudentById(int id) {
        Student st=studentRepository.findById(id).orElse(new Student());
        return st;
    }

    public boolean addStudent(Student student) {
        studentRepository.save(student);
        return true;
    }

    public boolean deleteById(int id) {
         studentRepository.deleteById(id);
        return true;
    }

    public Student updateById(int id, Student student) {
        studentRepository.updatebyId(student.getFirst_name(),student.getLast_name(),student.getId());
        //studentRepository.update(student);

        return student;
    }
}
