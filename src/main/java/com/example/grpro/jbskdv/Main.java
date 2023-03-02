package com.example.grpro.jbskdv;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
//                      jdbc:postgresql://localhost:5432/postgresql
        String url = "jdbc:postgresql://localhost:5432/postgres";


        Connection conn = DriverManager.getConnection(url, "postgres", "saxon1876");

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM cars.brands where id= 5");



        while (rs.next()) {
           int id=rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id+" "+name);
        }
        rs.close();
        stmt.close();
        conn.close();

    }

}
