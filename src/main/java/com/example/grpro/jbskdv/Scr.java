package com.example.grpro.jbskdv;

import java.sql.*;

public class Scr {
    public static Cars getdata(int id) throws SQLException {
//                      jdbc:postgresql://localhost:5432/postgresql
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";

        Connection conn = DriverManager.getConnection(url, "postgres", "saxon1876");

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM cars.brands where id= ?");

        Cars car=null;

        while (rs.next()) {
            id=rs.getInt("id");
            String name = rs.getString("name");
           car=new Cars(id,name);
        }
        rs.close();
        stmt.close();
        conn.close();
        return car;
    }
}
