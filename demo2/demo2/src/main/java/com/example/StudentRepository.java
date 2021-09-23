package com.example;

import io.micronaut.context.annotation.Executable;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
@Repository
public abstract class StudentRepository implements CrudRepository<Student,Integer> {


    @Query("UPDATE Student SET first_name = :first ,last_name = :last where id = :id")
    public abstract void updatebyId(String first,String last, int id);


}
