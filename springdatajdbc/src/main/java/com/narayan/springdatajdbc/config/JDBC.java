package com.narayan.springdatajdbc.config;


import com.narayan.springdatajdbc.details.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class JDBC {
    public int insert(UserDetails user){
        DataSource dataSource = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;
        try {
            dataSource = ConfigDataSource.source();
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("insert into user (user,username,password) values (?,?,?)");
            preparedStatement.setString(1 ,user.getUser());
            preparedStatement.setString(2,user.getUsername());

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10,new SecureRandom());

            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            preparedStatement.setString(3,encodedPassword);
            result = preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            log.getName();
        }

        return  result;
    }
}
