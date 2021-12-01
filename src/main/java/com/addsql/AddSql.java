package com.addsql;
import java.sql.*;
public class AddSql {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/names";
        String uname = "root";
        String pass = "Anki@9174";

        try {
            Connection connection = DriverManager.getConnection(dbURL, uname, pass);
            if (connection != null) {
                System.out.println("Connected!");
            }
            String sqlInsert = "INSERT INTO newnames (fname, lname, email) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, "Ankit");
            statement.setString(2, "Reddy");
            statement.setString(3, "reddy@gmail.com");
            statement.execute();
            statement.setString(1, "Anvesh");
            statement.setString(2, "Reddys");
            statement.setString(3, "anvesh@gmail.com");
            boolean rowsInserted = statement.execute();
            if (rowsInserted) {
                System.out.println("Rows or data added successfully!!");
            }
            String sqlInsert2 = "INSERT INTO newnames (fname, lname, email) values ('abc', 'def', 'as@gmail.com')";
            Statement readStat = connection.createStatement();
            readStat.execute(sqlInsert2);
            String sqlUpdate = "update newnames set fname=? where id=?";
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);
            preparedStatementUpdate.setString(1, "pqr");
            preparedStatementUpdate.setInt(2, 2);
            int rowsEffected = preparedStatementUpdate.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Data is updated!");
            }
            String sqlDelete = "DELETE FROM newnames WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, 1);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data is deleted!");
            }



                String sqlRead = "SELECT * FROM newnames";
                ResultSet resultSet = readStat.executeQuery(sqlRead);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String fname = resultSet.getString("fname");
                    String lname = resultSet.getString("lname");
                    String email = resultSet.getString("email");
                }


                connection.close();
            }catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
    }



