package com.example.grpro.jbskdv;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     String bid=request.getParameter("id");
     Integer id=Integer.valueOf(bid);

     Scr scr=new Scr();

            Cars car=null;

        try {
            car=scr.getdata(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(car);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(json);
    }
}