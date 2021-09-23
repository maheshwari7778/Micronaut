package com.example;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Requires;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.jdbc.runtime.JdbcOperations;
import io.micronaut.data.jdbc.runtime.PreparedStatementCallback;
import io.micronaut.data.model.query.builder.sql.Dialect;
import jakarta.inject.Singleton;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Requires(beans = JdbcTemplate.class)
public class Repo  {


    private final JdbcTemplate jdbcTemplate;

    public Repo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public int add(){
        String sql="into into db values(3,'welcome','back')";
        System.out.println("good by");
        String query="insert into employee values(?,?,?)";
        return jdbcTemplate.update(
                "INSERT INTO users VALUES (?, ?, ?)", 3, "Bill", "Gates");
    }

    @Transactional
    public List<Student> getAllStudent(){

        String sql="select * from users";
        List<Student> list = jdbcTemplate.query(
                sql,
                new StudentRowMapper());
       return list;
    }

    @Transactional
    public Student getStudentById(int id){
        String sql = "SELECT * FROM users WHERE id=?" ;
        //return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Student.class));
        RowMapper<Student>rowMapper=new rowMapperImpl();
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Transactional
    public boolean addStudent(Student student){
        String sql="INSERT INTO users Values(?,?,?)";
        int ret=jdbcTemplate.update(sql,student.getId(), student.getFirst_name(),student.getLast_name());
        if(ret>0)
            return true;
        else
            return false;

    }

    @Transactional
    public boolean deleteById(int id){
        String sql="DELETE from users where id=?";
        int ret=jdbcTemplate.update(sql,id);
        if(ret>0)
           return true;
        else
            return false;
    }

    @Transactional
    public boolean updateById( int id ,Student student){
        String sql="UPDATE users set first_name=? , last_name=? where id=?";
        int ret=jdbcTemplate.update(sql,student.getFirst_name(),student.getLast_name(),student.getId());

        if(ret>0)
            return true;
        else
            return false;
    }

}
