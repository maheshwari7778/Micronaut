package com.example;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student st=new Student();
        st.setId(resultSet.getInt(1));
        st.setFirst_name(resultSet.getString(2));
        st.setLast_name(resultSet.getString(3));
        return st;
    }
}
