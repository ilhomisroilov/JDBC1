package org.example;

import java.sql.*;

public class JDBCMethod {


    String URL="jdbc:postgresql://localhost:5432/postgres";
    String dbuser="postgres";
    String dbpassword="4";



    Connection connection;
    public User loginUser(String username,String password){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection=DriverManager.getConnection(URL,dbuser,dbpassword);
            String queury="select * from user2  where username=? and password=?";
            PreparedStatement preparedStatement=connection.prepareStatement(queury);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                String firstname=resultSet.getString(2);
                String lastname=resultSet.getString(3);
                String userName=resultSet.getString(4);
                User user=new User(id,firstname,lastname,userName);
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean saveUser(User user) {
        try {
            Connection connection = DriverManager.getConnection(URL, dbuser, dbpassword);
            String queury1 = "insert into user2(firstname,lastname,username,password) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(queury1);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPassword());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
