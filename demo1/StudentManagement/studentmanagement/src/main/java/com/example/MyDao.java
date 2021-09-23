package com.example;


import io.micronaut.data.jdbc.runtime.JdbcOperations;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class MyDao extends MyRepository {

    public MyDao(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Transactional
    public Long find() {
        String sql = "select * from users ";
        return this.jdbcOperations.prepareStatement(sql, st -> {

            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("first_name"));
                System.out.println(rs.getString("last_name"));
            }

            return 1L;
        });
    }
    @Transactional
    public long add(){

        System.out.println("good by");
        String sql = "insert into users values(8,'good','morning')";
        return this.jdbcOperations.prepareStatement(sql, st -> {

            st.executeUpdate();
            return 1L;
        });
    }

    @Transactional
    public List<Student> getAllStudent(){
        String sql="SELECT * from users";
        List<Student>list=new ArrayList<>();
        return jdbcOperations.prepareStatement(sql,statement -> {
            ResultSet rs=statement.executeQuery();

            while(rs.next()){
                Student student=new Student();
                student.setId(rs.getInt(1));
                student.setFirst_name(rs.getString(2));
                student.setLast_name(rs.getString(3));
                list.add(student);
            }
            return list;
                });
    }

    @Transactional
    public Student getStudentById(int id){
        String sql="select * from users where id=?";

        return jdbcOperations.prepareStatement(sql,statement -> {
           statement.setInt(1,id);
           ResultSet rs=statement.executeQuery();
           Student student=new Student();
           rs.next();
           student.setLast_name(rs.getString("last_name"));
           student.setId(rs.getInt("id"));
           student.setFirst_name(rs.getString("first_name"));
           return student;
        });
    }

    @Transactional
    public boolean addStudent(Student student){
        String sql="INSERT INTO users values(?,?,?)";
        return jdbcOperations.prepareStatement(sql,statement -> {
            statement.setInt(1,student.getId());
            statement.setString(2,student.getFirst_name());
            statement.setString(3, student.getLast_name());
            statement.executeUpdate();
            return true;
        });
    }

    @Transactional
    public boolean deleteById(int id){
        String sql="Delete from users where id=?";
        return jdbcOperations.prepareStatement(sql,statement -> {
            statement.setInt(1,id);
            statement.executeUpdate();
            return true;
        });

    }

    @Transactional
    public boolean updateById(int id,Student student){
        String sql="update users set first_name=?,last_name=? where id=?";
        return jdbcOperations.prepareStatement(sql,statement -> {
            statement.setInt(3,id);
            statement.setString(1,student.getFirst_name());
            statement.setString(2,student.getLast_name());
            statement.executeUpdate();
            return true;
        });

    }
}